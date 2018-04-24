/*
Dynamic Programming is useful especially in problems where the only solution is brute force, so it's helpful to at least
save your answers to the subproblems and utilize them throughout.
This is top-down DP (using recursion) whereas bottom-up DP uses for-loops

GUESSING: To get a small part of the solution that you don't already know (usually what is first or what is last (or 2nd to last in this case))
*/

public class LongestIncreasingSubsequence {

    private static int recurseLIS(int subIndex, int[] A, int[] DP) {    //sublength is length of curr array starting at 0
        // BASE CASES
        if (subIndex <= 0) return 0;

        // HAS THIS BEEN MEMOIZED?
        if (DP[subIndex] != -1) return DP[subIndex];

        // RECURRENCE RELATION, CALL YOUR RECURSIVE FUNCTION
        int longestSeq = 1;                                             //starts at 1 because if the array is at least length 1, the LIS will be at least 1
        for (int j=0; j < subIndex; j++) {                              //j is where the 2nd to last elem might be (guess)   //O(N)
            if (A[j] < A[subIndex]) {
                longestSeq = Math.max(longestSeq, recurseLIS(j, A, DP) + 1);
            }
        }

        // UPDATE THE MEMO
        DP[subIndex] = longestSeq;

        // RETURN THE ANSWER
        return longestSeq;
    }

    // Runtime: O(N^2) = O(A.length*A.length) = O(numSubProblems * timeOfOneSubProblem)
    // Space: O(N)
    public static int LIS(int[] A) {
        // INITIALIZE THE MEMO
        int[] memo = new int[A.length+1];
        for (int i=0; i < memo.length; i++) {
            memo[i] = -1;         //set special empty value
        }

        // CALL RECURSIVE FUNCTION ON PROBLEM THAT YOU WANT TO SOLVE, RETURNING THE ANSWER
        int longestSeq = 0;
        for (int i=0; i < A.length; i++) {
            longestSeq = Math.max(recurseLIS(i,A,memo), longestSeq);
        }
        return longestSeq;
    }
}