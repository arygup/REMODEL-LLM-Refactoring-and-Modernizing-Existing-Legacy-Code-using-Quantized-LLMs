# logger.py
import os
import datetime

class Logger:
    """Handles logging of prompts and outputs for a pipeline run."""

    def __init__(self, log_dir: str = "./logs"):
        # Create a unique, timestamped directory for this specific run
        timestamp = datetime.datetime.now().strftime("%Y-%m-%d_%H-%M-%S")
        self.run_dir = os.path.join(log_dir, timestamp)
        
        try:
            os.makedirs(self.run_dir, exist_ok=True)
            print(f"Logging run to: {self.run_dir}")
        except OSError as e:
            print(f"Error creating log directory {self.run_dir}: {e}")
            self.run_dir = None

    def log_translation_step(self, function_name: str, prompt: str, output: str):
        """Saves the prompt and output for a single function translation."""
        if not self.run_dir:
            print("  > Logging disabled due to directory creation failure.")
            return

        try:
            prompt_filename = f"{function_name}_prompt.txt"
            output_filename = f"{function_name}_output.txt"

            with open(os.path.join(self.run_dir, prompt_filename), 'w', encoding='utf-8') as f:
                f.write(prompt)

            with open(os.path.join(self.run_dir, output_filename), 'w', encoding='utf-8') as f:
                f.write(output)
                
        except IOError as e:
            print(f"  > Error writing log for {function_name}: {e}")
