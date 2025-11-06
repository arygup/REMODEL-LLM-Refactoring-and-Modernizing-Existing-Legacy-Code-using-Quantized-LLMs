import re
from typing import Dict, Optional
import ollama
from logger import Logger

class JavaTranslator:
    def __init__(self, model_name: str, logger: Logger):
        self.model_name = model_name
        self.logger = logger

        # --- FUNCTION PROMPT (FINAL Revisions for `&` and `printf`) ---
        # Note: All literal { and } in example code are now escaped as {{ and }}
        self.function_prompt_template = """You are a C-to-Java translation engine. Your task is to translate *only* the single C function provided.

**TASK:**
Translate the C function below into a single, syntactically correct Java method.

**C Function:**
{function_code}

**CONTEXT (For Type Information Only):**
- C Globals (if any): {globals_context}
- C Structs (if any): {structs_context}

**CRITICAL RULES. YOU MUST FOLLOW THESE:**
1.  **SINGLE FUNCTION ONLY:** Your *entire* response MUST be *only* the Java method.
    * **DO NOT** write `import` statements.
    * **DO NOT** write `class` definitions.
    * **DO NOT** include other methods, even if this function calls them.
    * **DO NOT** write explanations or markdown.
2.  **ILLEGAL KEYWORDS & PATTERNS (DO NOT USE):**
    * **`goto` (CRITICAL):** DO NOT write the keyword `goto`. C code using `goto` for cleanup (e.g., `if (err) goto cleanup; ... cleanup: ...`) MUST be restructured:
        1.  You MUST wrap the *relevant* C code in a Java `do_while_loop: do {{ ... }} while(false);` block.
        2.  The C `goto cleanup;` line MUST be translated to `break do_while_loop;`.
        3.  The C `cleanup:` label itself is translated as the code *after* the `}} while(false);` block.
    * **`union` (CRITICAL):** DO NOT write the keyword `union`.
        1.  Any C line that *declares* a `union` variable (e.g., `union Converter c;`) MUST be **DELETED**.
        2.  When that variable is *used* (e.g., `c.f = 1.2f; int i = c.i;`), you MUST translate this usage directly using Java's bit converters (e.g., `float f_val = 1.2f; int i = Float.floatToIntBits(f_val);`).
    * **`unsigned` (CRITICAL):** DO NOT write the keyword `unsigned`. Translate `unsigned int` to `long` and mask all arithmetic with `& 0xFFFFFFFFL`.
    * **`&` (Address-Of Operator - CRITICAL):** DO NOT use the `&` operator.
        1.  When passing a variable by pointer (e.g., `move(&p1);`), you MUST translate this to pass the Java reference directly: `move(p1);`.
        2.  (The *only* exception is C's `scanf`, which is not in these tests).
3.  **`main` FUNCTION:** If the C function name is 'main', the Java signature MUST be `public static void main(String[] args)`. All other functions MUST be `public static`.
4.  **`printf` (CRITICAL):** String literals inside `printf` (e.g., "Overflow ( + 1):") MUST be preserved **VERBATIM**.
    * Copy the string *exactly* as it appears in C.
    * **DO NOT** "fix" or "correct" spacing, typos, or formatting.
5.  **POINTER ARITHMETIC:**
    * `int *p = arr;` -> `int p_index = 0; int[] p_array = arr;`
    * `*(p + 2)` -> `p_array[p_index + 2]`.
    * `p++` -> `p_index++`.
6.  **STRUCT PASS-BY-VALUE:**
    * A C function `void move_copy(Point p_val)` receives a *copy*.
    * The Java method MUST create a copy: `public static void move_copy(Point p_val_orig) {{ Point p_val = new Point(p_val_orig); p_val.x += 100; }}`. (This assumes a copy constructor `Point(Point other)` exists).
7.  **MACRO INLINING:**
    * Macros with side effects MUST be inlined.
    * `int k = MAX(i++, j++);` -> `int k = ((i++) > (j++) ? (i++) : (j++));`
"""

        # --- GLOBAL PROMPT (Unchanged) ---
        self.global_prompt_template = """You are a C to Java translation expert. Your task is to convert the following C global variable into a 'public static' Java class field. Maintain the type and initial value.

**CRITICAL TRANSLATION RULES:**
1.  **Type:** Map C types to Java: `int` -> `int`, `float` -> `float`, `char*` -> `String`.
2.  **`const`:** `const` variables MUST be translated to `final` in Java.
3.  **`unsigned`:** `unsigned int` MUST be translated to `long`. `unsigned char` MUST be translated to `int`.
4.  **Visibility:** All globals become 'public static'.
5.  **Output:** Provide ONLY the single line of Java code.

The C code to translate is:
{c_code}
"""

        # --- STRUCT PROMPT (Unchanged) ---
        # Note: All literal { and } in example code are now escaped as {{ and }}
        self.struct_prompt_template = """You are a C to Java translation expert. Your task is to convert the following C struct or union definition into a 'public static' nested Java class.

**CRITICAL TRANSLATION RULES:**
1.  **`union` (CRITICAL):** If the C code provided is a `union`, you MUST output **NOTHING**. No text, no code, no comments. Just an empty string.
2.  **`struct` (Standard):** If the code is a `struct`, translate it to a `public static` Java class.
    * All C fields should become `public` Java fields.
    * `char name[50];` -> `public char[] name = new char[50];`
    * `char *name;` -> `public String name;`
3.  **CONSTRUCTORS (MANDATORY):** Your Java class MUST include all three of these constructors:
    1.  A `public` no-argument default constructor.
    2.  A `public` copy constructor that takes one argument (e.g., `public Point(Point other)`).
    3.  A `public` all-field constructor that takes arguments for *all* fields defined in the struct.
        * (e.g., for `Point {{ int x; int y; }}`, you MUST add `public Point(int x, int y) {{ this.x = x; this.y = y; }}`).
4.  **Bitfields:** `struct Flags {{ int a:1; }}` MUST be translated to a class with private data and public getters/setters using bit-masking.
5.  **Output:** Provide ONLY the Java class definition. Do not include `import` statements or any other text.

The C code to translate is:
{c_code}
"""
        self._verify_ollama()

    def translate_global(self, c_global_code: str) -> Optional[str]:
        prompt = self.global_prompt_template.format(c_code=c_global_code)
        print("  > Translating global variable...")
        return self._run_llm_translation("global", prompt)

    def translate_struct(self, c_struct_code: str) -> Optional[str]:
        prompt = self.struct_prompt_template.format(c_code=c_struct_code)
        print("  > Translating struct...")
        return self._run_llm_translation("struct", prompt)

    def translate_function(self, function_analysis: Dict, file_context: Dict) -> Optional[str]:
        prompt = self._construct_function_prompt(function_analysis, file_context)
        if not prompt:
             return f"// FAILED: Could not construct prompt for {function_analysis.get('name', 'unknown function')}"
        
        print(f"  > Translating function '{function_analysis['name']}'...")
        translated_code = self._run_llm_translation(function_analysis['name'], prompt)
        
        if translated_code:
            # First, strip imports
            code_no_imports = self._strip_imports(translated_code)
            # Second, strip any hallucinated class/method definitions
            return self._strip_extra_definitions(code_no_imports, function_analysis['name'])
        return translated_code

    def _construct_function_prompt(self, function_analysis: Dict, file_context: Dict) -> Optional[str]:
        try:
            clean_context = file_context.copy()
            if 'functions' in clean_context:
                del clean_context['functions']

            return self.function_prompt_template.format(
                globals_context='\n'.join(clean_context.get('global_variables', ['None'])),
                structs_context='\n'.join(clean_context.get('structs', ['None'])),
                function_code=function_analysis['code']
            )
        except KeyError as e:
            print(f"  > ERROR: Missing key in function_analysis or file_context: {e}")
            return None # Return None to signal failure

    def _run_llm_translation(self, task_name: str, prompt: str) -> Optional[str]:
        if prompt.startswith("// FAILED"):
            return prompt
        try:
            response = ollama.chat(
                model=self.model_name,
                messages=[{'role': 'user', 'content': prompt}]
            )
            raw_output = response['message']['content']
            self.logger.log_translation_step(task_name, prompt, raw_output)
            return self._extract_code_from_markdown(raw_output)
        except Exception as e:
            error_message = f"// FAILED_TRANSLATION for {task_name}. Reason: {e}"
            self.logger.log_translation_step(task_name, prompt, error_message)
            print(f"  > LLM translation failed for '{task_name}': {e}")
            return error_message

    def _extract_code_from_markdown(self, text: str) -> str:
        # Pattern to find code blocks in markdown
        pattern = r'```(?:java)?\n(.*?)```'
        matches = re.findall(pattern, text, re.DOTALL)
        
        if matches:
            return matches[0].strip()
        
        # Fallback: If no markdown block is found, assume the entire response is code
        stripped_text = text.strip()
        
        # Common LLM conversational intros to strip
        lines = stripped_text.split('\n')
        if lines and ("Here is the" in lines[0] or "Sure, here's" in lines[0] or "Here's the" in lines[0]):
            lines = lines[1:]

        # Common LLM conversational outros to strip
        if lines and ("I hope this" in lines[-1] or "Let me know" in lines[-1]):
            lines = lines[:-1]
            
        stripped_text = '\n'.join(lines).strip()

        # If it still contains ```, the regex might have failed. Try to clean it.
        if '```' in stripped_text:
             stripped_text = stripped_text.replace("```java", "").replace("```", "")
        
        if not stripped_text:
             return "// FAILED_EXTRACTION: LLM returned empty response."

        return stripped_text

    def _strip_imports(self, code: str) -> str:
        """
        A safety net to remove any 'import' statements hallucinated by the LLM.
        """
        if not code:
            return code
            
        cleaned_lines = []
        for line in code.split('\n'):
            if not line.strip().startswith('import '):
                cleaned_lines.append(line)
        
        return '\n'.join(cleaned_lines)

    def _strip_extra_definitions(self, code: str, expected_function_name: str) -> str:
        """
        A robust, non-regex safety net to extract only the one function
        we asked for, fixing the 'method already defined' error.
        """
        if not code:
            return code
        
        try:
            # 1. Find the start of the main function we want.
            # This regex is simple and just finds the *start* of the signature.
            pattern_str = r'(public|private)\s+static\s+.*?\s+' + re.escape(expected_function_name) + r'\s*\(.*?\)\s*\{'
            match = re.search(pattern_str, code, re.DOTALL)

            if not match:
                # Can't find the function. The LLM may have failed.
                # Let's check if it *only* returned a class
                if "class " in code and "public static" not in code:
                     return f"// FAILED_STRIPPING: LLM returned a class, not a method.\n{code}"
                # Return the code as-is and let it fail compilation
                return code 

            # 2. We found the start. Now, count braces to find the end.
            start_index = match.start()
            brace_start_index = match.end() - 1 # The index of the first '{'
            
            brace_count = 1
            end_index = -1
            
            # Start searching from *after* the first brace
            for i in range(brace_start_index + 1, len(code)):
                char = code[i]
                if char == '{':
                    brace_count += 1
                elif char == '}':
                    brace_count -= 1
                
                if brace_count == 0:
                    # We found the matching closing brace
                    end_index = i + 1
                    break
            
            if end_index != -1:
                # We found the function and its end. Extract it.
                return code[start_index:end_index]
            else:
                # This means braces were unbalanced. The code is malformed.
                # Return the original match (from start to end of string) and hope.
                return code[start_index:]
        
        except Exception as e:
            # Something went wrong, just return the original code with a warning
            return f"// FAILED_STRIPPING: Error during stripping: {e}\n{code}"


    def _verify_ollama(self):
        try:
            ollama_list = ollama.list()
            if 'models' in ollama_list:
                models = [m['name'] for m in ollama_list.get('models', [])]
                if not any(self.model_name in m for m in models):
                    print(f"Warning: Model '{self.model_name}' not found in Ollama.")
                    print(f"Available models: {models}")
            else:
                 print(f"Warning: 'models' key not in ollama.list() response. Full response: {ollama_list}")
        except Exception as e:
            print(f"Warning: Could not connect to Ollama. Is it running? Error: {e.__class__.__name__}: {e}")