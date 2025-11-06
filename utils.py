import os

def create_output_dir(dir_path: str):
    try:
        os.makedirs(dir_path, exist_ok=True)
        print(f"Output directory created/ensured at: {dir_path}")
    except OSError as e:
        print(f"Error creating directory {dir_path}: {e}")
        raise

def save_code_to_file(filepath: str, code: str):
    try:
        with open(filepath, 'w', encoding='utf-8') as f:
            f.write(code)
        print(f"Successfully saved Java code to {filepath}")
    except IOError as e:
        print(f"Error writing to file {filepath}: {e}")
        raise