package com.revature.lab;

import java.io.File;
import java.io.IOException;

public class PipelineSimulation {
    public final static boolean DELETE_DEPLOYMENT_WHEN_DONE = true;
    public final static boolean WAIT_BEFORE_COMPLETION = true;

    public static void main(String[] args) {
        System.out.println("--- Starting Pipeline ---");

        // Stage 1: Build
        if (!runStage("Build", () -> checkSourceCode()))
            return;

        // Stage 2: Test
        if (!runStage("Test", () -> runRandomTests()))
            return;

        // Stage 3: Package
        if (!runStage("Package", () -> createPackage()))
            return;

        // Stage 4: Deploy
        if (!runStage("Deploy", () -> deployArtifact()))
            return;

        System.out.println("--- Pipeline SUCCESS ---");
    }

    private static boolean runStage(String name, Supplier<Boolean> task) {
        System.out.println("Running Stage: " + name + "...");
        // TODO: Execute task and handle return value
        return task.get();
    }

    // TODO: Implement helper methods

    interface Supplier<T> {
        T get();
    }

    static Boolean checkSourceCode(){
        File source = new File("source_code.txt");
        boolean exists = source.exists();

        if (exists) IO.println("Compilation Success");
        else IO.println("Compilation error: source_code.txt couldn't be found");

        return exists;
    }
    static Boolean runRandomTests(){
        boolean rand = Math.random() < 0.5;

        if (rand) IO.println("Tests Passed");
        else IO.println("Tests Failed");

        return rand;
    }
    static Boolean createPackage(){
        File artifact = new File("artifact.jar");
        try {
            artifact.createNewFile();
        } catch (IOException e) {
            IO.println("Failed to create/touch artifact.jar");
            throw new RuntimeException(e);
        }

        return true;
    }
    static Boolean deployArtifact(){
        File folder = new File("deploy");
        folder.mkdir();

        File artifact = new File("artifact.jar");
        File dest = new File("deploy/artifact.jar");
        artifact.renameTo(dest);

        if (DELETE_DEPLOYMENT_WHEN_DONE) {
            folder.deleteOnExit();
            dest.deleteOnExit();
        }

        if (WAIT_BEFORE_COMPLETION) {
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                IO.println("Sleep interrupted.");
                throw new RuntimeException(e);
            }
        }

        return true;
    }

}
