import subprocess
import sys
import os
import pycparser
from typing import Optional, Dict, List, Set

from pycparser import c_parser, c_ast, c_generator
from pycparser.plyparser import ParseError

class CAnalyzer:
    """
    Analyzes C code using a visitor pattern on the AST for robust categorization
    of code elements like functions, structs, globals, and typedefs.
    """

    def __init__(self):
        self.parser = c_parser.CParser()
        self.generator = c_generator.CGenerator()

    def _preprocess_c_code(self, c_filepath: str) -> str:
        """Preprocesses C code using gcc and pycparser's fake libc headers."""
        pycparser_path = os.path.dirname(pycparser.__file__)
        fake_libc_path = os.path.join(pycparser_path, 'utils', 'fake_libc_include')
        
        if not os.path.exists(fake_libc_path):
            local_path = './fake_libc_include'
            if os.path.exists(local_path):
                fake_libc_path = local_path
            else:
                raise RuntimeError("Could not find pycparser's fake libc includes.")

        command = ['gcc', '-E', '-nostdinc', '-I', fake_libc_path, '-I', os.path.dirname(c_filepath), c_filepath]
        try:
            # Added -D'__attribute__(x)=' to strip gcc-specific keywords that pycparser fails on.
            command.insert(1, '-D__attribute__(x)=')
            process = subprocess.run(command, capture_output=True, text=True, check=True)
            return process.stdout
        except (subprocess.CalledProcessError, FileNotFoundError) as e:
            error_details = e.stderr if hasattr(e, 'stderr') else str(e)
            print(f"FATAL: Failed to preprocess with gcc. Error: {error_details}")
            raise

    def analyze_c_file(self, c_filepath: str) -> Optional[Dict]:
        """
        Parses a C file and uses a visitor to extract a detailed context map.
        """
        try:
            preprocessed_code = self._preprocess_c_code(c_filepath)
            ast = self.parser.parse(preprocessed_code, filename=c_filepath)
            
            # Use the intelligent visitor to categorize everything
            visitor = ContextVisitor(c_filepath, self.generator)
            visitor.visit(ast)
            
            # Analyze each found function for its details (complexity, calls)
            for func_name, func_node in visitor.context['function_nodes'].items():
                func_details = self._analyze_function_node(func_node)
                # Find the corresponding entry in the functions list and update it
                for func in visitor.context['functions']:
                    if func['name'] == func_name:
                        func.update(func_details)
                        break

            # Clean up temporary data before returning
            del visitor.context['function_nodes']
            
            return visitor.context

        except ParseError as e:
            print(f"Could not parse {c_filepath}: {e}")
            return None
        except Exception as e:
            print(f"An unexpected error occurred while analyzing {c_filepath}: {e}")
            # Reraise for more detailed debugging if needed
            raise

    def _analyze_function_node(self, func_node: c_ast.FuncDef) -> Dict:
        """Analyzes a single function's body for complexity and calls."""
        call_visitor = CallVisitor()
        call_visitor.visit(func_node.body)
        
        complexity_visitor = ComplexityVisitor()
        complexity_visitor.visit(func_node.body)
        
        return {
            "complexity": complexity_visitor.complexity,
            "called_functions": list(call_visitor.called_functions)
        }


class ContextVisitor(c_ast.NodeVisitor):
    """
    An intelligent AST visitor that correctly categorizes all top-level
    declarations in a C file.
    """
    def __init__(self, original_filepath: str, generator: c_generator.CGenerator):
        self.original_filepath = original_filepath
        self.generator = generator
        self.context = {
            "global_variables": [],
            "structs": [],
            "enums": [],
            "function_pointers": [],
            "function_declarations": [],
            "functions": [],
            "function_nodes": {} # Temporary storage for function AST nodes
        }

    def visit_Decl(self, node):
        # Filter out anything not from the original source file
        if not (node.coord and self.original_filepath in node.coord.file):
            return

        # Case 1: Function Declaration (Prototype)
        if isinstance(node.type, c_ast.FuncDecl):
            self.context['function_declarations'].append(self.generator.visit(node))
        
        # Case 2: Struct/Union/Enum Definitions or Forward Declarations
        elif isinstance(node.type, (c_ast.Struct, c_ast.Union, c_ast.Enum)):
            # It's a forward declaration if it has no body (decls)
            if node.type.decls is None:
                pass # We can safely ignore forward declarations for translation
            else:
                code = self.generator.visit(node)
                if isinstance(node.type, c_ast.Struct):
                    self.context['structs'].append(code)
                elif isinstance(node.type, c_ast.Enum):
                    self.context['enums'].append(code)
        
        # Case 3: Global Variable
        else:
            self.context['global_variables'].append(self.generator.visit(node))

    def visit_Typedef(self, node):
        if not (node.coord and self.original_filepath in node.coord.file):
            return
        
        code = self.generator.visit(node)
        
        # Case 1: Typedef for a struct, e.g., typedef struct { ... } MyStruct;
        if isinstance(node.type.type, c_ast.Struct):
            self.context['structs'].append(code)
        
        # Case 2: Typedef for an enum
        elif isinstance(node.type.type, c_ast.Enum):
            self.context['enums'].append(code)

        # Case 3: Typedef for a function pointer, e.g., typedef void (*MyFunc)(int);
        elif (isinstance(node.type, c_ast.PtrDecl) and 
              isinstance(node.type.type, c_ast.FuncDecl)):
            self.context['function_pointers'].append(code)
        
        # Other simple typedefs can be ignored or handled here if needed
        # For now, we assume they are not critical for the Java translation context.

    def visit_FuncDef(self, node):
        if not (node.decl.coord and self.original_filepath in node.decl.coord.file):
            return

        func_name = node.decl.name
        self.context['functions'].append({
            "name": func_name,
            "code": self.generator.visit(node)
        })
        # Store the raw node for later analysis of its body
        self.context['function_nodes'][func_name] = node


# --- Helper Visitors (for complexity and function calls) ---

class ComplexityVisitor(c_ast.NodeVisitor):
    def __init__(self): self.complexity = 1
    def visit_If(self, n): self.complexity += 1; self.generic_visit(n)
    def visit_For(self, n): self.complexity += 1; self.generic_visit(n)
    def visit_While(self, n): self.complexity += 1; self.generic_visit(n)
    def visit_DoWhile(self, n): self.complexity += 1; self.generic_visit(n)
    def visit_Case(self, n): self.complexity += 1; self.generic_visit(n)
    def visit_BinaryOp(self, n):
        if n.op in ('&&', '||'): self.complexity += 1
        self.generic_visit(n)
    def visit_TernaryOp(self, n): self.complexity += 1; self.generic_visit(n)

class CallVisitor(c_ast.NodeVisitor):
    def __init__(self): self.called_functions = set()
    def visit_FuncCall(self, n):
        if hasattr(n.name, 'name'): self.called_functions.add(n.name.name)
        self.generic_visit(n)