# HW 14 - BST/Divide+Conquer Review

**This assignment is due Friday, March 16**


## Learning Goals

By doing this assignment, you should

* Gain practice working with BSTs and/or Divide/Conquer algorithms, and using them write efficient algorithms

## Assignment

**For this assignment, pick one of the two following problems**:

## Divide and Conquer

Choose one of the three problems from the [the D+C conquer HW](https://github.com/Olin-DSA/DSA-18/tree/master/sorting/day04) to do (do not choose the one you have already done). Make sure you note your Base Case, Divide, Conquer, Combine steps, and determine the runtime of your algorithm.

## Range Queries

You are tasked with designing a data structure which supports efficient range-queries. More specifically, you will receive a series of input keys (as integers), and you must be able to perform the two following operations efficiently:

* `rangeCount(lo, hi)` return the number of keys that are in the bounds `lo <= k <= hi`
* `rangeIndex(lo, hi)` return a sorted list of all keys that are in the bounds `lo <= k <= hi`

We recommend an AVLTree as a starting point, and have provided our solution in the file `AVLRangeTree`. **It is expected that you modify `AVLRangeTree`, and/or `BinarySearchTree`, and/or `RangeNode`.** Augment the data structure in order to more efficiently perform these operations. Your `AVLRangeTree`'s performance on `insert`, `delete`, and `find` must remain `O(logN).`

<details>
  <summary>Hint 1: Optimal Complexities</summary>
  `rangeCount` should run in `O(log(N)`. `indexRange` should run in `O(log(N) + L)`, where `L = hi - lo`.
</details>

<details>
  <summary>Hint 2: `rangeCount`</summary>
  As a first step, write a function `rank(k)` which returns the number of keys <= k.
</details>

<details>
  <summary>Hint 3: `rangeCount`</summary>
  Augment the `RangeNode` to store the number of nodes in its subtree.
</details>

<details>
  <summary>Hint 4: `indexRange`</summary>
  Your solution to this will look quite similar to an in-order-traversal.
</details>

**As always, consider the runtime of any code you write**
