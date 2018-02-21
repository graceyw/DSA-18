# Sorting Day 2 - Review

## Learning Goals

By doing this assignment, you should be able to

* Use sorting algorithms and data structures to write efficient algorithms

## Assignment

**Choose 3 of the following 4 problems to do for this homework**

Note: If you need to sort an array/list in your algorithm, use the sort method provided by java. You don't need to write your own sort function again.

### Largest subarray with equal number of 0s and 1s
Given an array containing only 0s and 1s, find the largest subarray which contain equal number of 0s and 1s.

For example, given arr[] =  {1, 0, 1, 1, 1, 0, 0}, the output is [1,6] meaning index from 1 to 6. **Your algorithm must run faster than O(N^2)**.

<details> 
  <summary>Hint 1</summary>
  What if the problem was instead: given an array of 1s and -1s, output the largest subarray whose sum is 0?
</details>

<details> 
  <summary>Hint 2</summary>
  How can you use Hashmaps to your advantage in this problem?
</details>

### Frequncy Count

`FrequencyCount()` takes in a String and returns the distinct values found and the number of times each was found, in ascending order of the frequencies. **Make sure your algorithm is faster than O(N^2).** Bonus points (not really...though it would be pretty cool) if your algorithm runs faster than O(NlogN).

For example, if the input is {to be or not to be to}, the output is either {or not be be to to to} or {not or be be to to to}.


### Triple Sum
Given an array of n distinct integers, design an algorithm that counts the number of unique triples that sum to a given amount. Your solution should take O(N^2) in time. You cannot use the element at a certain index multiple times in one triple.

Given arr[] = {-1,0,1,2,3,4} and sum = 4,the function will return 3. There are {-1,1,4}, {-1,2,3} and {0,1,3}

<details> 
  <summary>Hint 1</summary>
  How can you solve the Pair-Sum problem in O(N) time? Can you use this solution as part of your triple sum algorithm?
</details>

<details> 
  <summary>Hint 2</summary>
  Sorting the array as a first step may simplify the problem
</details>

### Locks and Keys  

You have a mixed pile of N locks and N keys and need to quickly find the corresponding pairs of locks and keys. Each lock matches exactly one key, and each key matches exactly one lock. By fitting a lock and key together, you can see which is bigger. **But it is not possible to directly compare two locks or two keys**. Write an efficient methods which sorts both arrays such that that locks and keys align with eachother, and are sorted. (You can't use the built in sort function, because this will compare locks to locks, and keys to keys).

Both locks and keys are represented as array of character:  
Input:
char lock[] = {‘@’, ‘#’, ‘$’, ‘%’, ‘^’, ‘&’}
char key[] = {‘$’, ‘%’, ‘&’, ‘^’, ‘@’, ‘#’}  
Output:
char lock[] = {‘#’, ‘$’, ‘%’, ‘&’, ‘@’, ‘^’}
char key[] = {‘#’, ‘$’, ‘%’, ‘&’, ‘@’, ‘^’}

<details> 
  <summary>Hint 1</summary>
  Use a custom implementation of quicksort to sort both arrays
</details>

## Getting Checked Off

- Talk your NINJA through your solution to the 3 algorithms you implemented.
