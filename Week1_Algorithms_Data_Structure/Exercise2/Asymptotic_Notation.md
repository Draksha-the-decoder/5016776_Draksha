# Search Functionality in E-Commerce Platform

## 1. Big O Notation

Big O notation is a mathematical notation used in computer science to describe the upper bound or worst-case scenario of the runtime complexity of an algorithm in terms of the input size. It provides a standardized and concise way to express how the performance of an algorithm scales as the size of the input grows
- **O(1)**: Constant time complexity, where the algorithm's runtime remains constant regardless of the input size.
- **O(log n)**: Logarithmic time complexity, where the algorithm's runtime grows logarithmically with the input size.
- **O(n)**: Linear time complexity, where the algorithm's runtime grows linearly with the input size.
- **O(n log n)**: Linearithmic time complexity, commonly seen in efficient sorting algorithms like mergesort and heapsort.
- **O(n^2)**: Quadratic time complexity, where the algorithm's runtime grows quadratically with the input size.

## 2. Search Operations: Best, Average, and Worst-Case Scenarios

### Linear Search
- Simple and works on unsorted arrays.
- Best for small datasets or when the cost of sorting outweighs the benefits of faster search.
- Performance degrades linearly with the size of the array.
##### Best-case scenario:
**O(1)**: The target element is the first element in the array.
**Example**: Searching for `1` in `[1, 2, 3, 4, 5]`.

##### Average-case scenario:
**O(n/2) which simplifies to O(n)**: The target element is somewhere in the middle of the array.
**Example**: Searching for `3` in `[1, 2, 3, 4, 5]`.

##### Worst-case scenario:
**O(n)**: The target element is the last element in the array or not present at all.
**Example**: Searching for `5` in `[1, 2, 3, 4, 5]` or searching for `6` in `[1, 2, 3, 4, 5]`.

### Binary Search
- Requires the array to be sorted.
- More efficient for larger datasets.
- Performance improves logarithmically with the size of the array.

##### Best-case scenario:
**O(1)**: The target element is the middle element of the array.
**Example**: Searching for `3` in `[1, 2, 3, 4, 5]`.

##### Average-case scenario:
**O(log n)**: The target element is located somewhere in the array, necessitating a few iterations.
**Example**: Searching for `2` in `[1, 2, 3, 4, 5]`, where the search progresses through `3 -> 1 -> 2`.

##### Worst-case scenario:
**O(log n)**: The target element is not present in the array, or it is one of the end elements.
**Example**: Searching for `6` in `[1, 2, 3, 4, 5]` or searching for `1` or `5` in `[1, 2, 3, 4, 5]`.


