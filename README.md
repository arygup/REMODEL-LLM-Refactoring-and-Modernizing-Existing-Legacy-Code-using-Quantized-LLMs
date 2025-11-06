# REMODEL-LLM: Refactoring and Modernizing Existing Legacy Code using Quantized LLMs

## Overview

**REMODEL-LLM** is a research grade system that performs **automated refactoring, translation, and modernization of legacy codebases** using **quantized large language models (LLMs)** combined with **static program analysis**.
The framework targets real-world C and C++ repositories and transforms them into cleaner, safer, and more maintainable modern equivalents (e.g., Java or modern C++).

It integrates **AST based static analysis** (via `pycparser`) with **LLM guided reasoning and translation**, leveraging contextual metadata from the program structure to preserve semantics while improving style, safety, and maintainability.

---

## Pipeline Architecture

REMODEL-LLM operates in four main stages:

1. **Static Analysis (`c_analyzer.py`)**

   * Parses source code using `pycparser` to construct an Abstract Syntax Tree (AST).
   * Extracts structured contexts:

     * Global variables, structs, enums, typedefs
     * Function definitions and declarations
   * Computes code metrics such as cyclomatic complexity and inter-function call graphs.

2. **Refactoring and Translation (`modernizer.py`)**

   * Constructs structured prompts enriched with AST context for the target model.
   * Performs refactoring and modernization, addressing:

     * Deprecated patterns (`goto`, unsafe pointer operations)
     * Type normalization and idiomatic transformation.
   * Uses quantized Ollama models (e.g., `deepseek-coder-v2`, `codellama`) for efficient translation and generation.

3. **Execution & Verification (`code_executor.py`)**

   * Compiles and executes both source and refactored code to ensure behavioral equivalence.
   * Logs runtime outputs for regression testing and semantic verification.

4. **Logging & Traceability (`logger.py`)**

   * Maintains detailed logs of prompts, responses, and intermediate artifacts.
   * Facilitates reproducibility and debugging of model outputs.

---

## Key Features

| Feature                        | Description                                                               |
| ------------------------------ | ------------------------------------------------------------------------- |
| **Static AST Analysis**        | Extracts program structure and relationships for context-aware prompting. |
| **Quantized LLM Integration**  | Utilizes quantized models for efficient and scalable inference.           |
| **Semantic Preservation**      | Ensures behavioral equivalence between original and refactored code.      |
| **Cross-Language Translation** | Supports migration from legacy C/C++ to modern Java/C++.                  |
| **Complexity Analysis**        | Computes per-function metrics to guide refactoring strategies.            |
| **Reproducible Logging**       | Stores all prompt–response traces for interpretability.                   |

---

## Project Structure

```
REMODEL-LLM/
├── c_analyzer.py        # Extracts AST and identifies code entities
├── modernizer.py        # Refactors and translates using quantized LLMs
├── code_executor.py     # Executes and validates translated code
├── logger.py            # Handles logging of all intermediate steps
├── fake_libc_include/   # Optional libc headers for pycparser
├── Legacy_repo/         # Input legacy source code
└── Modern_repo_<model>/ # Auto-generated modernized output
```

---

## Requirements

* Python dependencies:

  ```bash
  pip install pycparser ollama
  ```

---

## Usage

```bash
python c_analyzer.py --input <path_to_source_file>
python modernizer.py --model deepseek-coder-v2
python code_executor.py --run sample_legacy.c
```

Or to run the full integrated pipeline:

```bash
python main.py  --model deepseek-coder-v2 --verify
```

---

## Example Workflow

1. Place your legacy code files in `Legacy_repo/`.
2. Run the modernization pipeline:

   ```bash
   python main.py --model deepseek-coder-v2 --verify
   ```
3. Refactored and translated files will appear under `Modern_repo_deepseek-coder-v2/`.
4. Logs for all prompts, responses, and code comparisons will be stored under:

   ```
   logs/YYYY-MM-DD_HH-MM-SS/
   ├── prompts.log
   └── verification.log
   ```

---

## Experimental Goals

This project supports the research paper **“REMODEL-LLM: Refactoring and Modernizing Existing Legacy Code using Quantized LLMs”**, aiming to explore:

* LLM-driven refactoring strategies for legacy procedural code
* Effect of quantization on translation fidelity and speed
* Semantic preservation through AST-guided prompting
* Model evaluation across code complexity levels

---

## Authors

**Aryan Gupta**
CCNSB, IIIT Hyderabad
Hyderabad, India
[aryan.g@research.iiit.ac.in](mailto:aryan.g@research.iiit.ac.in)

**Y. Raghu Reddy**
SERC, IIIT Hyderabad
Hyderabad, India
[raghu.reddy@iiit.ac.in](mailto:raghu.reddy@iiit.ac.in)

---

## Citation

If you use this framework in your research, please cite:

```
@inproceedings{gupta2025remodel,
  title={REMODEL-LLM: Refactoring and Modernizing Existing Legacy Code using Quantized LLMs},
  author={Gupta, Aryan and Reddy, Y. Raghu},
  institution={IIIT Hyderabad},
  year={2025}
}
```
