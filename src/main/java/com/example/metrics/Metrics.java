package com.example.metrics;


public class Metrics {
    private long comparisons;
    private long swaps;
    private int currentDepth;
    private int maxDepth;

    public void incComparisons() { comparisons++; }
    public void incSwaps() { swaps++; }

    public void enterRecursion() {
        currentDepth++;
        if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
        }
    }

    public void exitRecursion() {
        currentDepth--;
    }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public int getMaxDepth() { return maxDepth; }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        currentDepth = 0;
        maxDepth = 0;
    }
}
