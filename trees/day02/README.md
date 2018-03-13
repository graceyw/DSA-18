# Trees Day 2 - 2-3 Trees, and Left-Leaning Red Black Trees

* [Slides](https://docs.google.com/presentation/d/1IMxdH8EADvO8qTZkdLQmgW-lrxRTfB-HnehpNtfkqUY/edit?usp=sharing) from class lecture
* [Princeton Lecture Notes](https://www.cs.princeton.edu/~rs/talks/LLRB/RedBlack.pdf)
* [Princeton Lecture On 23 Trees](https://youtu.be/akTKlqMEAUg?t=1m38s)
* [Princeton Lecture On LLRB Trees](https://www.youtube.com/watch?v=2Ae0D6EXBV4)

This assignment is due Monday, March 12th

## Learning Goals

By doing this assignment, you will:
* Understand why a 2-3 tree's balance factor is always 0
* Understand what a 2-3 tree's equivalent LLRB is
* Identify legal/illegal LLRBs
* Be able to insert into an LLRB and have it still be legal
* Know the runtime complexity of insert/search/delete in an LLRB

## Exercises

Build both a 2-3 tree and a LLRB for the following array (inserting in order):

- `[8, 1, 4, 0, 2, 7, 10, 9]`

Make sure you draw each step (and keep it). Your NINJA will ask you to walk through the procress.

## Code

#### Changes

- We have created a new class called `RedBlackTree`. It includes helper functions such as `isRed` and `isBlack`
- `RedBlackTree` contains two functions: `is23` and `isBalanced`, which can be used to verify that a tree is a legal LLRB (we asked you to write these two algorithms in PSET today. Read them and make sure you understand them, since the test suite relies on them)
- `TreeNode` now does NOT keep track of the height of the node. Instead, it stores `color`.

### Implementation

#### `insert(TreeNode<T> n, T key)`

Implement `insert` based on the lecture in class and the materials we've provided above.

Note that in order to implement `insert`, there are some helper functions you should write:

 * `rotateRight(TreeNode<T> n)`
 * `rotateLeft(TreeNode<T> n)`
 * `flipColors(TreeNode<T> n)`
 * `balance(TreeNode<T> n)`

All of these functions have tests (except `balance`, which is tested by `insert`). You will probably find writing your own tests is helpful as well.

Make sure you note the runtime of `insert` in your comments.

#### (Optional) `delete(TreeNode<T> h, T key)`

We did not cover deletion in 2-3/LLRB trees today in class. Use the **Princeton Lecture Notes** to implement delete in your LLRB (sadly, the video lecture omits it).
