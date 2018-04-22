# Introduction to Dynamic Programming

## Learning Goals

Students will:

- Become familiar with the 5 steps of DP (Subproblems, Guess, Recurrence Relation, Memoize, Solution)
- Apply the 5 steps to algorithms problems
- Be able to design and write their own DP algorithms
- Analyze the runtime of DP algorithms

## Resources

- Bae Erik Demaine does an entire series on DP. Today's lecture borrowed elements from the [first one](https://youtu.be/OQ5jsbhAv_M?t=56s)
  - [Here](https://youtu.be/OQ5jsbhAv_M?t=6m4s) is the timestamp for his Fibonacci number example. This is a classic DP example, although we chose not to cover it because you don't actually need the Guess step (you almost always do for DP problems)
  - [Here](https://youtu.be/OQ5jsbhAv_M?t=32m29s) is the timestamp for his coverage of the shortest paths problem. We went over this in lecture. If you want to skip to the part we didn't cover (how to use this DP approach for cyclic graphs), skip [here](https://youtu.be/OQ6jsbhAv_M?t=47m19s)
- Here's a great DP [tutorial](https://www.topcoder.com/community/data-science/data-science-tutorials/dynamic-programming-from-novice-to-advanced/), if you want more practice implementing algorithms outside of your homework assignments.

For this homework, we have included a general DP template, but do not feel compelled to use if you would rather not. We have also included a solution to the making-change problem from lecture today.

## Assignment

**Choose 2 of the following problems. Make sure you note what each of the 5 DP steps are for the problem (as done today in lecture). Your NINJA will ask you to explain these 5 steps when you are checked off. Also, note your time/space complexity**

### Dice roll sum

Professor Ben is curious how many 6-sided dice roll sequences there are that reach a sum of `N`. For example, if `N=10`, one possible sequence is: `[6, 2, 2]`. Another is `[2, 6, 2]`. Another is `[3, 3, 3, 1]` Write a function that returns the number of sequences. For `N=0`, return `1` (there is one sequence...the empty sequence `[]`).

### Longest increasing subsequence

Given an unsorted array of integers, what is the length of the longest increasing subsequence? Subsequence is defined as: a sequence that can be derived from the array by removing zero or more elements. Some examples:

- Given `[5, 3, 1, 5, 8, 10]`, the LIS is `[3, 5, 8, 10]`, so your function returns `4`.
- Given `[5, 4, 3, 4, 2, 5]`, the LIS is `[3, 4, 5]`, so your function returns `3`.
- Given `[1, 2, 3]`, return `3`.
- Given `[3, 2, 1]`, return `1`.

### Longest common subsequence

Given two strings, return the length of their longest common subsequence (subsequence defined above). For example, given `BENJAMIN` and `STEELMAN`, the LCS is `EMN` or `EAN`, so your function should return `3`.
