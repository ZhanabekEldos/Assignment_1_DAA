package org.example;

public class Metrics {
    private long comparisons = 0;
    private long allocations = 0;
    private long recursionDepth = 0;
    private long currentDepth = 0;
    private long startTime;
    private long endTime;

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        endTime = System.nanoTime();
    }

    public long getElapsedTimeNs() {
        return endTime - startTime;
    }

    // --- Comparisons ---
    public void incComparisons() {
        comparisons++;
    }

    public long getComparisons() {
        return comparisons;
    }

    // --- Allocations ---
    public void incAllocations() {
        allocations++;
    }

    public long getAllocations() {
        return allocations;
    }

    // --- Recursion depth ---
    public void enterRecursion() {
        currentDepth++;
        recursionDepth = Math.max(recursionDepth, currentDepth);
    }

    public void exitRecursion() {
        currentDepth--;
    }

    public long getMaxRecursionDepth() {
        return recursionDepth;
    }

    public void reset() {
        comparisons = 0;
        allocations = 0;
        recursionDepth = 0;
        currentDepth = 0;
        startTime = 0;
        endTime = 0;
    }

    @Override
    public String toString() {
        return "Metrics{" +
                "comparisons=" + comparisons +
                ", allocations=" + allocations +
                ", maxRecursionDepth=" + recursionDepth +
                ", elapsedTime(ns)=" + getElapsedTimeNs() +
                '}';
    }
}
