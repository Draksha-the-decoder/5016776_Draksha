# Search Algorithms

## Linear Search

### Algorithm

1. Start from the beginning of the array.
2. Compare each element with the target element.
3. If a match is found, return the element's index or the element itself.
4. If the end of the array is reached without finding the target, return null or indicate the target is not present.

### Time Complexity

- **Best-Case:** `O(1)` - When the target is the first element.
- **Average-Case:** `O(n)` - On average, you might need to scan half of the array.
- **Worst-Case:** `O(n)` - When the target is the last element or not present.

## Binary Search

### Algorithm

1. Ensure the array is sorted.
2. Start with the middle element of the array.
3. Compare the middle element with the target.
4. If it matches, return the element's index or the element itself.
5. If the target is less than the middle element, narrow the search to the left half.
6. If the target is greater, narrow the search to the right half.
7. Repeat steps 3-6 until the target is found or the search space is empty.

### Time Complexity

- **Best-Case:** `O(1)` - When the target is the middle element.
- **Average-Case:** `O(log n)` - Each step halves the search space.
- **Worst-Case:** `O(log n)` - The search space is reduced exponentially.

## Comparison of Time Complexity

- **Linear Search:** `O(n)` - Performance degrades linearly with the size of the array. It is straightforward but becomes less efficient as the size of the dataset increases.
- **Binary Search:** `O(log n)` - Performance improves logarithmically with the size of the array. It is much more efficient for large datasets but requires the array to be sorted.

## When to Use Each Algorithm

### Linear Search
- The dataset is small.
- The dataset is unsorted.

**Advantages:**
- No need for the data to be sorted.

**Disadvantages:**
- Less efficient for large datasets.

### Binary Search
- The dataset is large.
- The dataset is sorted or can be sorted.

**Advantages:**
- Highly efficient for large datasets.

**Disadvantages:**
- Requires a sorted dataset and is more complex to implement.
