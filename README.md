# Functional Programming with Scala - UCSC

This repository contains practical Scala code for the Functional Programming module, part of the BSc. Computer Science at UCSC, taken in the 2nd year, 1st semester. It's organized weekly, with Scala files in respective directories.

## Compilation and Execution
A PowerShell script, run_project.ps1, automates the compilation of Scala files listed in files_to_compile.txt. This setup allows using a single App object with a main method to run different Scala files based on command-line input, overcoming Scala's limitation with multiple main functions. The process:

- Reads Scala file paths from files_to_compile.txt.
- Compiles them into an out directory.
- Checks for successful compilation.
- On success, instructs on running the App with a filename argument.
- This approach enhances flexibility, maintainability, and scalability, streamlining the compilation and execution process.


## Script Details
- **Read Scala File Paths**: Reads paths from `files_to_compile.txt` into an array.
- **Compile Scala Files**: Utilizes `scalac` with `-d out` option to compile files into the `out` directory.
- **Check Compilation Success**: Outputs "Compilation successful" along with instructions if compilation succeeds; otherwise, prints "Compilation failed".
- **Running the Script**:
  - Open PowerShell in the project folder.
  - Set execution policy with `Set-ExecutionPolicy RemoteSigned -Scope CurrentUser` if necessary.
  - Execute the script with `.\run_project.ps1`.