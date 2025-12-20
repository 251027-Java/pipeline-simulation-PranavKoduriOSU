# Lab: Simulate a CI/CD Pipeline

## Goal
Write a shell script (or Java program) that simulates a Build Pipeline. This helps understand the logic flow of CI/CD without needing a heavy Jenkins server.

## Requirements
1.  **Script**: Create `pipeline.sh` (or `Pipeline.java`).
2.  **Steps**:
    -   **Step 1 (Compile)**: Check if a dummy file `source_code.txt` exists. If yes, print "Compilation Success". If no, print "Error" and exit.
    -   **Step 2 (Test)**: Run a command that randomly passes or fails (use `RANDOM` in bash or `Math.random()` in Java).
        -   If fail: Print "Tests Failed", Exit.
        -   If pass: Print "Tests Passed", Continue.
    -   **Step 3 (Package)**: Create a file named `artifact.jar` (touch it).
    -   **Step 4 (Deploy)**: Move `artifact.jar` to a `deploy/` folder.

## Starter Code
-   `PipelineSimulation.java` provided.
