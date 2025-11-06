# main.py
import argparse
from pipeline_manager import PipelineManager
from java_translator import JavaTranslator
from logger import Logger
import os

def main():
    parser = argparse.ArgumentParser(description="C to Java Translation Pipeline")
    parser.add_argument('--input-dir', type=str, default='./C_repo', help='C source directory.')
    parser.add_argument('--model', type=str, default='deepseek-coder-v2', help='Ollama model name.')
    parser.add_argument('--output-dir', type=str, default=None, help='Java output directory.')
    parser.add_argument(
        '--verify',
        action='store_true',  
        help='If set, compile and run both C and Java code to verify output.'
    )
    args = parser.parse_args()

    if args.output_dir is None:
        args.output_dir = f"./Java_repo_{args.model}"

    os.makedirs(args.output_dir, exist_ok=True)

    logger = Logger()
    translator = JavaTranslator(model_name=args.model, logger=logger)
    # --- Pass the logger to the manager ---
    manager = PipelineManager(translator=translator, logger=logger)
    
    # --- Pass the verify flag to the run method ---
    manager.run_pipeline(
        input_dir=args.input_dir,
        output_dir=args.output_dir,
        verify=args.verify
    )

if __name__ == "__main__":
    main()