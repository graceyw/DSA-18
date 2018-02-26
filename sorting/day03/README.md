# Sorting Day 3 - Counting and Radix Sort

**This assignment is due Tuesday, February 27th**

## Learning Goals

By doing this assignment, you should be able to

* Understand the implementation of counting and radix sort, and why using `LinkedLists` is useful.
* Identify use cases for counting and radix sort
* Understand the runtime of the linear-in-N sorts

## Resources
* [Slides on linear sorting](https://drive.google.com/open?id=1W7X7p5-jymr_jNh_RdQIAyWLeu2VhIjH)
* [Counting Sort - MIT OCW Lecture 37:00 - 44:30](https://youtu.be/Nz1KZXbghj8?t=37m1s)
* [Counting Sort - MIT OCW Lecture Notes](https://drive.google.com/file/d/0B_K4P69ad_l_TTNDUFM1QzA3OFk/view)
* [Radix Sort - MIT OCW Lecture 44:30-50:00](https://youtu.be/Nz1KZXbghj8?t=44m30s)

## Sorts

**Note that all sorts in this assignment should modify the input array**

### Counting Sort

Fill in `countingSort(int[] A)` in `CountingSort.java`. 

Note the runtime in the comments. **Express your runtime in terms of n and k.**

### Stable Counting Sort

In order to radix sort, we first have to be able to sort the array according to a certain digit.

For this function, you will need to use an implementation of counting sort which actually keeps a reference to each value in your array. Think about what would happen if we used counting sort to sort the array `[35, 12, 88, 39]` by the 10s place. First, we generate the counts array `[0, 1, 0, 2, 0, 0, 0, 0, 1, 0]` (one number begins with `1`, two begin with `3`, one with `8`) Then, we generate our output array based on the counts array: `[1, 3, 3, 8]`. We no longer actually know what the original numbers were, so this implementation of counting sort cannot be used in radix sort.

Start by watching [this](https://youtu.be/Nz1KZXbghj8?t=37m1s) MIT OCW lecture about counting sort, and an implementation that keeps references to each value. Watch from 37:01-44:30.

The lecture notes are [here](https://drive.google.com/open?id=0B_K4P69ad_l_TTNDUFM1QzA3OFk), along with the pseudocode for counting sort on page 3.

Fill in `countingSortByDigit(int[] A, int b, int n)` in `RadixSort.java`. Note the helper function `getNthDigit(int number, int base, int n)`. To check that you implemented it correctly, run its test. If your test fails, make sure you are adding elements from the linked lists in the correct order (from front to back).

### Radix Sort

Finally, fill in `radixSort(int[] A, int b)` in `RadixSort.java`. Note the runtime in the comments. **Express your runtime in terms of n, b, and w.**

If you're having trouble with radix sort, you can continue watching the [MIT lecture](https://youtu.be/Nz1KZXbghj8?t=44m30s). Watch up to 50:01. If you want to get into the math behind the runtime of radix sort, watch through the end.

## Problems

### Sort numbers between -100 and 100.

You are given an array of integers in the range [-100, 100], inclusive. Write a function to sort them as quickly as possible. Feel free to use code you've already written.

<details> 
  <summary>Hint 1</summary>
  How can you modify the data you are given to make working with it easier?
</details>

### Sort array of `String`s

You are given an array of Strings, all with the same length, all lower case characters. How can you sort the strings using the concepts covered in class and this homework?

You will probably find it useful to have a function that sorts the array by the character at a given index in the String. Start by filling in `countingSortByCharacter` in `Problems.java`. This function should be *very* similar to `countingSortByDigit`.

Note the helper function `getNthCharacter(String s, int n)`. This returns the nth character of the String as an integer. That is, calling `getNthCharacter("katie", 1)` would return `8`, because the character `i` is the 8th letter in the alphabet (indexing from 0). `getNthCharacter("katie", 3)` returns `0`, because `'a'=0`

<details> 
  <summary>Hint 1</summary>
  Take advantage of the fact that radix sort does not have be in base 10.
</details>

## Optional: Counting Swaps (Review)

Given an array of integers, return the number of swaps that must be performed between adjacent indices to sort the array. Your solution should run in `O(n log(n))`. A sorted or empty array should return 0.

<details> 
  <summary>Hint 1</summary>
  For every instance of an array in which A[i] > A[j] while i < j, a swap will have to be performed.
</details>

<details> 
  <summary>Hint 2</summary>
  Merge sort allows for comparison of adjacent elements at its lowest level. It also allows for comparison of indexes between already sorted arrays as it recurses up during merges.
</details>
