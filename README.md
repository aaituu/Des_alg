# Design and analisys of algorithm Project

## Overview
This project implements classic divide-and-conquer algorithms in Java, collects performance metrics, and validates running-time behavior.  
Algorithms included:

- **MergeSort** – with linear merge, reusable buffer, and small-n cutoff (insertion sort).
- **QuickSort** – randomized pivot, recurse on smaller partition first, iterative over larger partition.
- **Deterministic Select (Median-of-Medians, MoM5)** – O(n) guaranteed selection of k-th smallest element.
- **Closest Pair (2D)** – divide-and-conquer algorithm for finding the closest pair of points.

Metrics collected include **execution time (ms), max recursion depth, comparisons, swaps**.

---

## Algorithms

### MergeSort
- Linear merge
- Reusable buffer
- Small-n cutoff (insertion sort)
- Tested for arrays of various sizes

### QuickSort
- Randomized pivot
- Recurse on smaller partition, iterate over larger
- Bounded stack depth ≈ O(log n)

### Deterministic Select
- Groups of 5 elements
- Median of medians pivot selection
- Only recurse into necessary side

### Closest Pair
- Sort points by x-coordinate
- Recursive splitting and strip checking by y-coordinate
- Efficiently finds closest pair in O(n log n)

---

## Metrics Example

Metrics collected using `Metrics` class and CLI CSV output.  
Example results (simulated, based on typical runs):

| Algorithm      | Size | Time (ms) | Max Depth | Comparisons | Swaps |
|----------------|------|-----------|-----------|-------------|-------|
| MergeSort      | 1000 | 5         | 10        | 8,500       | 4,500 |
| MergeSort      | 5000 | 28        | 13        | 110,000     | 55,000|
| MergeSort      |10000 | 62        | 14        | 240,000     |120,000|
| QuickSort      | 1000 | 3         | 12        | 7,900       | 4,200 |
| QuickSort      | 5000 | 18        | 15        |105,000      | 52,000|
| QuickSort      |10000 | 40        | 16        |230,000      |115,000|
| Deterministic Select |1000 | 2     | 8         | 10,500      | 5,000 |
| Deterministic Select |5000 | 10    | 10        | 55,000      | 27,000|
| Deterministic Select |10000| 22    | 11        |115,000      | 57,000|
| Closest Pair   | 1000 | 6         | 9         | N/A         | N/A   |
| Closest Pair   | 5000 | 35        | 12        | N/A         | N/A   |
| Closest Pair   |10000 | 80        | 13        | N/A         | N/A   |

> Note: Comparisons and Swaps are only for sorting algorithms. Closest Pair outputs only execution time and recursion depth.

---

## Running the Program

Compile and run via CLI:

```bash
mvn clean compile

# MergeSort
java -cp target\classes com.example.cli.CLI --algo mergesort --size 1000 --output mergesort_1000.csv

# QuickSort
java -cp target\classes com.example.cli.CLI --algo quicksort --size 1000 --output quicksort_1000.csv

# Deterministic Select
java -cp target\classes com.example.cli.CLI --algo select --size 1000 --output select_1000.csv

# Closest Pair
java -cp target\classes com.example.cli.CLI --algo closest --size 1000 --output closest_1000.csv
