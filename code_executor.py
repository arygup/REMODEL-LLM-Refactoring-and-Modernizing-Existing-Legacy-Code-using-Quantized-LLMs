# code_executor.py
import subprocess
import os
from typing import Tuple

class CodeExecutor:
    """Handles compiling and running C and Java code for verification."""

    def compile_and_run_c(self, c_filepath: str) -> Tuple[bool, str, str]:
        """
        Compiles and runs a C file, capturing its output.

        Returns:
            A tuple (success, output, error_message).
        """
        base_name = os.path.splitext(c_filepath)[0]
        executable_path = f"{base_name}_c_executable"
        
        # 1. Compile the C code
        compile_command = ['gcc', c_filepath, '-o', executable_path, '-lm']
        try:
            compile_proc = subprocess.run(
                compile_command, capture_output=True, text=True, check=True
            )
        except (subprocess.CalledProcessError, FileNotFoundError) as e:
            error = e.stderr if hasattr(e, 'stderr') else str(e)
            return False, "", f"C Compilation Failed: {error}"

        # 2. Run the compiled executable
        try:
            run_proc = subprocess.run(
                [f"./{executable_path}"], capture_output=True, text=True, check=True, timeout=5
            )
            # Clean up the executable file after running
            os.remove(executable_path)
            return True, run_proc.stdout, ""
        except (subprocess.CalledProcessError, FileNotFoundError, subprocess.TimeoutExpired) as e:
            error = e.stderr if hasattr(e, 'stderr') else str(e)
            os.remove(executable_path) # Still clean up on failure
            return False, "", f"C Execution Failed: {error}"


    def compile_and_run_java(self, java_filepath: str) -> Tuple[bool, str, str]:
        """
        Compiles and runs a Java file, capturing its output.

        Returns:
            A tuple (success, output, error_message).
        """
        source_dir = os.path.dirname(java_filepath)
        class_name = os.path.splitext(os.path.basename(java_filepath))[0]
        
        # 1. Compile the Java code
        compile_command = ['javac', java_filepath]
        try:
            compile_proc = subprocess.run(
                compile_command, capture_output=True, text=True, check=True
            )
        except (subprocess.CalledProcessError, FileNotFoundError) as e:
            error = e.stderr if hasattr(e, 'stderr') else str(e)
            return False, "", f"Java Compilation Failed: {error}"
            
        # 2. Run the compiled Java code
        # We must specify the classpath (-cp) so Java knows where to find the .class file
        run_command = ['java', '-cp', source_dir, class_name]
        class_file = os.path.join(source_dir, f"{class_name}.class")
        try:
            run_proc = subprocess.run(
                run_command, capture_output=True, text=True, check=True, timeout=5
            )
            # Clean up the .class file
            os.remove(class_file)
            return True, run_proc.stdout, ""
        except (subprocess.CalledProcessError, FileNotFoundError, subprocess.TimeoutExpired) as e:
            error = e.stderr if hasattr(e, 'stderr') else str(e)
            os.remove(class_file) # Still clean up on failure
            return False, "", f"Java Execution Failed: {error}"
