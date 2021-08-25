#### Merge sort

*Worst-case performance:O(n\*log n)*

*Average-case performance:O(n\*log n)*

*Best-case performance:O(n\*log n)*

__Merge sort__ - recursive algorithm that divides a given array into subarrays, until it reaches one element in the array
(an array which contains one element is always sorted), and then merges these elements into one sorted array.

- Uses more memory but fewer CPU resources, memory is used to create new arrays(divided and merged).
- Can be parallelized (sort in separate threads first part and second part of the array).
- In the case of a partially sorted array, the number of operations and memory is not reduced.
- Works better on large arrays than *Insertion sort*.
- Cannot dynamically add new elements to the array during sorting.

#### Insertion sort

*Worst-case performance:O(n^2)*

*Average-case performance:O(n^2)*

*Best-case performance:O(n)*

__Insertion sort__ - sorting algorithm based on the comparison of elements, in which the left always remains part of the 
sorted array.

- In the case of a partially sorted array, the number of nested iterations is reduced.
- Uses less memory then *Merge sort*.
- Can dynamically add new elements to the array during sorting.
- Poor performance on large arrays.