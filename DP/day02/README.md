# Dynamic Programming - Day02

**This assignment is due Thursday night, May 3rd**

## Learning Goals
- Practice dynamic programming problem solving steps
- Learn to identify and design a DP solution for more difficult problems

## Resources

- Walkthrough of the weighted interval problem from class today: https://www.youtube.com/watch?v=cr6Ip0J9izc
- Erik Demaine's lecture on text justification: https://youtu.be/ENyox7kNKeY
- The DP implementation PDF we handed out in class today: https://drive.google.com/open?id=156zlHrsjV72xLNYHfVyOoGE99XNZomVu

## Assignment

You are free to write these solutions in whichever manner you prefer, top-down or bottom-up. Implement at least **two** of the three following problems.

### Text Justification

Given a body of text as an array of strings in order (`w`) and the maximum length (`m`) of a line, return a `List` of the indices of the first word of each line of justified text.  For example:

```
w = {"This", "is", "an", "example", "of", "text", "justification"}
m = 16

This   is    an
example of text
justification
```

should return the array `{0, 3, 6}`.

The cost of line l is c(l):
* c(l) = INF, if total_length(l) > m
* c(l) = (m - total_length(l))^3, otherwise

where:
* total_length = words + single space between each word (i.e. the number of words in the line - 1)
* m = the maximum length of a line

<details>
  <summary>Hint 1</summary>
  For your subproblem definition, use suffixes: `w[i:]`
</details>


<details>
  <summary>Hint 2</summary>
  Where does the first line break go?
</details>

<details>
  <summary>Hint 3</summary>
  Your subproblem definition will contain the minimum cost for a suffix of words. However, your function needs to return where the line breaks go (not the minimum cost achieved with those line breaks).
</details>

<details>
  <summary>Hint 4</summary>
  Keep an array separate from your `DP` memo, `nextBreak`, where `nextBreak[i]` represents the optimal place to put the next line break, if there is a line break before `w[i]`.
</details>

### Regex Matching
Write a function that implements regular expression matching for `'.'` and `'*'`. `'.'` matches any single character, while `'*'` matches 0 or more of the preceding character. The matching should cover the entire input string. Your inputs will be `s`, the input string, and `p`, the regular expression.

For example:

```
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
```

<details>
  <summary>Hint 1</summary>
  Think about edit distance from the last homework
</details>

<details>
  <summary>Hint 2</summary>
  Try drawing out a 2D matrix (like in edit distance) with its axes being indexes into the string and the regex.
</details>

<details>
  <summary>Hint 3</summary>
  For your subproblem, think about: "Does `s[:i+1]`` match `p[:j+1]`?" What if `p[j]` is a `.`? What if its a `*`?
</details>


### Balloon Popping
You are given a list `B` of balloons. Each balloon is worth a specified amount of points represented by its value in the list. You must find the maximum value you can achieve by popping the balloons in the optimal order.

When you pop a balloon, you gain points equal to the product of the value of that balloons with the values of the balloons on its left and right. Then, that balloon disappears and its neighbors move together.

Return the maximum points possible

For example:
```
Input: [2, 4, 3, 5]
Choices=    3           4         2         5
List = [2,4,3,5] --> [2,4,5] --> [2,5] --> [5] --> []
Points =  4*3*5   +   2*4*5   +  1*2*5 + 1*5*1   = 115
Return 115
```

<details>
  <summary>Hint 1</summary>
  For your guess, think about where the *last* balloon you want to pop is.
</details>

<details>
  <summary>Hint 2</summary>
  Use subarrays as your subproblem. That is, `DP[i, j]` is the max value obtained by popping `B[i:j]` (our solution did this where both bounds are inclusive). In this case, if `i > j`, then `DP[i][j] = 0`
</details>

<details>
  <summary>Hint 3</summary>
  If `k` is the index of your choice for the last balloon top pop, `i<=k<=j`, you obtain value `B[i-1] * D[k] * B[j + 1]`. This is because `B[k]` is the last balloon in the subarray we pop, so all balloons on its left and right in the bounds `[i, j]` are gone, so the values you multiply by are at `i-1` and `j+1`
</details>

<details>
  <summary>Hint 4</summary>
  Your given problem becomes a subproblem in hint 2 if you pad the outside with 1s.
</details>
