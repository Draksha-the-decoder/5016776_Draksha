# Sorting Algorithms

### Bubble Sort
A simple comparison-based algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.

**Time Complexity**:
- Worst Case: O(n^2)
- Average Case: O(n^2)
- Best Case: O(n) (when the list is already sorted)

### Insertion Sort
Builds the final sorted list one item at a time, inserting each new item into its proper position within the already sorted section.

**Time Complexity**:
- Worst Case: O(n^2)
- Average Case: O(n^2)
- Best Case: O(n) (when the list is already sorted)

### Quick Sort
A divide-and-conquer algorithm that picks an element as a pivot and partitions the array around the pivot such that elements less than the pivot are on the left and elements greater than the pivot are on the right.

**Time Complexity**:
- Worst Case: O(n^2) (rare and depends on pivot selection)
- Average Case: O(n log n)
- Best Case: O(n log n)

### Merge Sort
A divide-and-conquer algorithm that divides the array into two halves, recursively sorts them, and then merges the sorted halves back together.

**Time Complexity**:
- All Cases: O(n log n)

## Analysis of Time Complexity

### Bubble Sort
- **Worst Case**: O(n^2)
- **Average Case**: O(n^2)
- **Best Case**: O(n)

### Quick Sort
- **Worst Case**: O(n^2) (depends on pivot selection)
- **Average Case**: O(n log n)
- **Best Case**: O(n log n)

## Why Quick Sort is Generally Preferred Over Bubble Sort

- **Efficiency**: Quick Sort generally has better average-case performance (O(n log n)) compared to Bubble Sort's O(n^2) average-case performance.
- **Scalability**: Quick Sort scales better with larger datasets due to its more efficient time complexity.
- **Real-World Performance**: Quick Sort performs well in practice because it is cache-friendly and has low overhead, making it faster than other O(n log n) algorithms like Merge Sort for many types of data.
