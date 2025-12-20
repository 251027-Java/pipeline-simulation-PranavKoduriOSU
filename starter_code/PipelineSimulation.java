package com.revature.lab;

import java.io.File;
import java.io.IOException;

public class PipelineSimulation {

    public static void main(String[] args) {
        System.out.println("--- Starting Pipeline ---");

        // Stage 1: Build
        if (!runStage("Build", () -> checkSourceCode()))
            return;

        // Stage 2: Test
        if (!runStage("Test", () -> runRandomTests()))
            return;

        // Stage 3: Deploy
        if (!runStage("Deploy", () -> deployArtifact()))
            return;

        System.out.println("--- Pipeline SUCCESS ---");
    }

    private static boolean runStage(String name, Supplier<Boolean> task) {
        System.out.println("Running Stage: " + name + "...");
        // TODO: Execute task and handle return value
        return true;
    }

    // TODO: Implement helper methods

    interface Supplier<T> {
        T get();
    }
}
