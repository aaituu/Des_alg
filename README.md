# Assignment 1 — Divide and Conquer Algorithms

![Java CI](https://github.com/aaituu/Des_alg/actions/workflows/ci.yml/badge.svg)

## Overview
This project implements and analyzes classic **divide-and-conquer algorithms** with recursion safety and performance measurements.

### Algorithms
- MergeSort (D&C, Master Case 2)
- QuickSort (randomized pivot, bounded recursion depth)
- Deterministic Select (Median-of-Medians)
- Closest Pair of Points in 2D

### Metrics
- Execution time
- Recursion depth
- Comparisons and allocations

### Learning Goals
- Implement divide-and-conquer algorithms safely
- Analyze recurrence relations (Master Theorem, Akra–Bazzi)
- Validate theory with empirical measurements
- Report findings in `readme.md`

## Git Workflow
- `main` → only stable releases
- feature branches → one algorithm/part each
- commits follow assignment storyline

## Build & Test
```bash
mvn clean test
