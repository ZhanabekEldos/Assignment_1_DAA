# Algorithms Assignment — Divide & Conquer

## Introduction
This project implements four classical divide-and-conquer algorithms:
- **MergeSort**
- **QuickSort** (with randomized pivot)
- **Deterministic Select** (Median of Medians)
- **Closest Pair of Points (2D)**

## Project Architecture
- **Algorithms:** `MergeSort`, `QuickSort`, `DeterministicSelect`, `ClosestPair`
- **Metrics:** `Metrics` class to track execution time, recursion depth, comparisons, and allocations
- **Tests:** JUnit5 for correctness and recursion depth validation
- **CLI:** `Main.java` for running experiments and exporting results

## Theory (Recurrence Analysis)
- **MergeSort:** T(n) = 2T(n/2) + Θ(n) → Θ(n log n)
- **QuickSort:** T(n) = T(k) + T(n-k-1) + Θ(n) → average Θ(n log n)
- **Deterministic Select:** T(n) = T(n/5) + T(7n/10) + Θ(n) → Θ(n)
- **Closest Pair:** T(n) = 2T(n/2) + Θ(n) → Θ(n log n)

## Results
- (To be filled: insert plots and CSV tables with experimental results)
- Example program run:  

Before sort: 7 6 4 5 3 1 2
After sort: 1 2 3 4 5 6 7


*(Add plots for time vs n, recursion depth, etc. if available)*

## Testing
- **MergeSort/QuickSort:** validated on random and adversarial arrays
- **Select:** validated by comparing against `Arrays.sort()[k]`
- **Closest Pair:** validated on small n against O(n²) brute-force solution

## Run Instructions
```bash
mvn clean install
mvn test
java -cp target/algo-project-1.0-SNAPSHOT.jar org.example.Main
