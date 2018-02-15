# Sorting Day 1 - Quicksort, Heaps and `HeapSort`

## Learning Goals

By doing this assignment, you should be able to:

* Understand and justify the runtime and space complexities of quicksort
  * Why quicksort is O(logN) space
* Understand how these two sorts are implemented.
* Avoid worst case performances (time and/or space) of Quick sort by randomly shuffling before sorting
* Understand the heap sort algorithm:
  * Understand why building a heap is O(N) time
  * Understand why heap sort is worst, average and best case O(NlogN) time
  * Understand the O(1) space complexity of heap sort
* Understand how to implement a priority queue
  * How to implement it using a max-heap

## Resources

* You can find our slides about heapsort [here](https://drive.google.com/open?id=1FymC42ujtVceMMYiw9Wa8vMU1ehTvf7uLgcyuIutN68).
* [Princeton Algorithms lecture on binary heaps](https://www.youtube.com/watch?v=U_TfcSpQmNc)
* [MIT lecture slides](https://drive.google.com/open?id=1A-T35tNHuOmlW4Y_u_65HMSGGzBsIljC) on Quicksort, which also covers why randomization guarantees O(NlogN) time. Corresponding lecture [here](https://www.youtube.com/watch?v=vK_q-C-kXhs)
* Quick [stackexchange](https://cs.stackexchange.com/questions/35509/can-anybody-explain-intuitively-why-quick-sort-need-logn-extra-space-and-merge) covering space complexity of Quicksort vs Mergesort

## Assignment

### Quicksort + Heapsort

- For both `HeapSort.java` and `QuickShort.java`, complete the methods annotated with `TODO`s so that `sort` runs; use (or not) the helper methods and method declarations we've provided for you.

- Detail the best, worst, and average case runtime complexity in the comments. Also, detail the space complexity.

### Running Median

For this problem, you might find it helpful to use a priority queue (PQ). Java offers an implementation of `PriorityQueue`, with the following methods:

- `isEmpty`
- `size`
- `peek`
- `offer`, which is the same as `enqueue` from the queue you implemented.
- `poll`, which is the same as `dequeue` from the queue you implemented.

[Here's](https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html) the API.

#### The Problem

You are given an input stream of integers `inputStream`. Return a `double[] runningMedian`, where `runningMedian[i]` is the median of all elements in `inputStream[:i+1]`, that is, up to and including `i`.

You can think of it like you are seeing the integers one at a time, and at any given time you must output what the median of all the integers you've seen so far is.

You may find it helpful to think about the O(N^2) solution first. Maintain a sorted dynamic array `sortedArray`, and after each element comes in, find its place in the sorted array and insert it, then output the median of the sorted array. Why is this O(N^2)?

The code for the N^2 solution is provided in `Problems.java`. Can you do better? For your convenience, we provide two helper functions which initialize a maxPQ and a minPQ which store Integers. Feel free to use one or both in your solution.

##### Hints

<details> 
  <summary>Hint 1</summary>
    In order to find the median of an array, we only need to know the value of either one or two elements in the corresponding sorted array. For example, if currently we've seen elements `[4, 3, 1, 5, 2]`, we only need one element from the corresponding sorted array `[1, 2, 3, 4, 5]`, which is the one at index `2` (which is `3`). If we add a number (say, 4), then the sorted array becomes `[1, 2, 3, 4, 4, 5]`, and we only need to know the elements at indices `2` and `3` to calculate the median (which evaluates to `3.5`).
</details>

<details> 
  <summary>Hint 2</summary>
    If, as we receive numbers in our input stream we can successfully store 2 numbers: 1. The number after the median (when the array is in sorted order), and 2. The number before the median (or the median itself, if the array is odd-length), then we can calculate the median each time we receive a new number. 
</details>

<details> 
  <summary>Hint 3</summary>
    Store all the numbers before or equal to the median in one data-structure, and all the numbers after the median in another data-structure. Which data structure will allow you to quickly find the median each time you see a number, and to shift elements back-and-forth quickly?
</details>

## Getting Checked Off

- Provide an explanation for each of the four heapsort complexities to your NINJA.
- Provide an explanation for each of the four quicksort complexities to your NINJA.
- Talk your NINJA through your solution to the running median problem
