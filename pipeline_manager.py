import os
from c_analyzer import CAnalyzer
from java_translator import JavaTranslator
from utils import save_code_to_file, create_output_dir
from logger import Logger
from code_executor import CodeExecutor

class PipelineManager:
    def __init__(self, translator: JavaTranslator, logger: Logger):
        self.analyzer = CAnalyzer()
        self.translator = translator
        self.logger = logger
        self.executor = CodeExecutor()

    def run_pipeline(self, input_dir: str, output_dir: str, verify: bool):
        """Processes C files and optionally verifies the output."""
        print(f"Starting pipeline: {input_dir} -> {output_dir}")
        create_output_dir(output_dir)

        for root, _, files in os.walk(input_dir):
            for file in files:
                if file.endswith('.c'):
                    # --- THIS IS THE CRITICAL SECTION ---
                    # The full path to the C file must be constructed here.
                    c_filepath = os.path.join(root, file)
                    # And then passed to the processing function.
                    self._process_file(c_filepath, output_dir, verify)
        
        print("Pipeline finished.")

    def _process_file(self, c_filepath: str, output_dir: str, verify: bool):
        print(f"\nProcessing file: {c_filepath}")
        
        analysis_result = self.analyzer.analyze_c_file(c_filepath)
        if not analysis_result:
            print(f"  > Analysis failed for {c_filepath}. Skipping.")
            return

        class_name = os.path.splitext(os.path.basename(c_filepath))[0].capitalize()
        
        java_code_parts = [f"public class {class_name} {{"]

        # 1. Translate Global Variables
        if analysis_result.get('global_variables'):
            for c_global in analysis_result['global_variables']:
                java_field = self.translator.translate_global(c_global)
                if java_field:
                    java_code_parts.append("\n" + self._indent_code(java_field))

        # 2. Translate Structs
        if analysis_result.get('structs'):
            for c_struct in analysis_result['structs']:
                java_class = self.translator.translate_struct(c_struct)
                if java_class:
                    java_code_parts.append("\n" + self._indent_code(java_class))

        # 3. Translate Functions
        if analysis_result.get('functions'):
            for func_analysis in analysis_result['functions']:
                java_method = self.translator.translate_function(func_analysis, analysis_result)
                if java_method:
                    java_code_parts.append("\n" + self._indent_code(java_method))

        java_code_parts.append("\n}") # Close class
        
        final_java_code = "\n".join(java_code_parts)
        java_filename = f"{class_name}.java"
        output_filepath = os.path.join(output_dir, java_filename)
        save_code_to_file(output_filepath, final_java_code)

        # Verification stage
        if verify:
            print("\n--- Verification Stage ---")
            print(f"  > Compiling and running C baseline: {c_filepath}")
            c_success, c_output, c_error = self.executor.compile_and_run_c(c_filepath)
            if not c_success:
                print(f"  > C FAILED: {c_error}")
                return

            print(f"  > Compiling and running translated Java: {output_filepath}")
            java_success, java_output, java_error = self.executor.compile_and_run_java(output_filepath)
            if not java_success:
                print(f"  > Java FAILED: {java_error}")
                return

            print("  > Comparing outputs...")
            if c_output.strip() == java_output.strip():
                print("  > SUCCESS: Outputs match!")
            else:
                print("  > FAILURE: Outputs do not match.")
                print("--- C Output ---")
                print(c_output)
                print("--- Java Output ---")
                print(java_output)
            print("--- Verification Finished ---")

    def _indent_code(self, code: str, level: int = 1) -> str:
        """Helper to indent a block of code."""
        indent = "    " * level
        return "\n".join([indent + line for line in code.split('\n')])