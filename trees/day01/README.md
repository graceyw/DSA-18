# HW 12 - AVL Trees

**This assignment is due Friday, March 9th**

## Feedback and Responses

[This link](https://docs.google.com/document/d/1RV_HCr8e2KmnIBQ1NwCcQmmA2R7Ifq7I-DZENCbh2aU/edit?usp=sharing) leads to our responses to the feedback session we had two weeks ago. We did our best to explain what we could, could not, would, and would not implement based on these. As always, if you have continued feedback or if you feel a comment was misunderstood, please reach out to / talk with us.

## Learning Goals

By doing this assignment, you should be able to

* Understand what it means for a tree to be balanced
* Understand the implementation of an AVL tree
* Understand the runtime of operations performed on AVL trees

## Resources
* [Slides](https://docs.google.com/presentation/d/1-g9vro8MddzA_VaScRGNgwZtIQ0QO7a556Ov39jHAes/edit?usp=sharing)
* [MIT Lecture](https://www.youtube.com/watch?v=FNeL18KsWPc&feature=youtu.be)
* [MIT Notes](https://drive.google.com/open?id=1ZVGk7NRJDvuvLc2X80leysgOhCMsuoNN)
* [AVL Tree generator](https://visualgo.net/avl)

## Visualization

Either:

Draw out an unbalanced tree and have a classmate balance it

**or**

Draw out and label each step that must be performed to balance this tree:

![](tree.png?raw=true)

## Code

### Changes

- We have already provided you a solution for the last hw in `BinarySearchTree.java`.
- We have created a new class called `AVLTree`, which extends our BST class.
- `TreeNode` now keeps track of the height of the node, but we have not written any code to modify that field; this should be done in `AVLTree`.
- You should not have to modify `BinarySearchTree`.
- Parent pointers in the `TreeNode` class has been removed. This is to reduce work for you when performing rotations (fewer pointers changes).

### The new `delete` method

Given that parent pointers are now gone, `BST.delete` can no longer rely on `findSuccessor` or `findPredecessor`. We fixed that by writing a new method, `deleteMin(n)`, in `BST`, that we use to replace n with its right child's minimum (aka successor). We provide you with both `BST` and `AVL` versions of `deleteMin`. 

**You should read through and understand ALL pieces of code described above**

### Implementation

Fill out the following functions:

 * `height(TreeNode<T> n)` Return the height of a given node
 * `rotateRight(TreeNode<T> n)` Rotate a given node right
 * `rotateLeft(TreeNode<T> n)` Roate a given node left
 * `balanceFactor(TreeNode<T> n)` Return the balance factor of the node `n`.
 * `balance(TreeNode<T> n)` Balance the tree rooted at `n`.
 * `insert(TreeNode<T> n, T key)` Insert an element into the tree rooted at `n`, maintaining balance.
 * `delete(TreeNode<T> n, T key)` Delete an element from the tree rooted at `n`, maintaining balance.

Run corresponding tests in `AVLTreeTest.java` to make sure your implementations are correct.


### Least Sums (Review)

Using a given array of integers, 0 through 9 (there can be duplicates), as the digits, construct two numbers such that their sum is as small as possible. Your solution should run in `O(n)`.

Given: [2, 2, 8, 1, 3, 1]
Return: 123 + 128 = 251


**As always, consider the runtime of any code you write**
