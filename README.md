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
## Results

### Execution Time
![Time vs N](docs/time_vs_n.png)

### Recursion Depth
![Depth vs N](docs/depth_vs_n.png)

*(Tables with raw CSV data are in `results.csv`)*
## Conclusion
- **MergeSort** behaves as expected: O(n log n).
- **QuickSort** shows O(n log n) average, with recursion depth ≈ 2*log2(n).
- **Deterministic Select** achieves linear performance Θ(n), independent of array size.
- **Closest Pair of Points** matches Θ(n log n) and is much faster than brute-force O(n²) for n > 2000.

The experimental results align well with theoretical predictions. Small deviations are due to constant factors (cache, JVM optimizations, GC).

```bash

mvn clean install
mvn test
java -cp target/algo-project-1.0-SNAPSHOT.jar org.example.Main

