public class DiceRollSum {

    private static int recurseDice(int sum, int[] DP) {   //Only arguments that are part of subproblem, and your memo
        // BASE CASES
        if (sum==0) return 1;
        if (sum<0) return 0; //didn't find it

        // HAS THIS BEEN MEMOIZED?
        if (DP[sum] != -1) return DP[sum];    //if it's already in the memo, just return that solution

        // RECURRENCE RELATION, CALL YOUR RECURSIVE FUNCTION
        int numSeq = 0;
        for (int i=1; i <= 6; i++) {
            numSeq += recurseDice(sum-i,DP);
        }

        // UPDATE MEMO
        DP[sum] = numSeq;

        // RETURN THE ANSWER
        return numSeq;
    }

    // Runtime: O(N*6) = O(num of subproblems * time per subproblem)
    // Space: O(N) because memo
    public static int diceRollSum(int N) {

        // INITIALIZE THE MEMO
        int[] DP = new int[N+1];
        for (int i=0; i < DP.length; i++) {
            DP[i] = -1;   //set a special empty value
        }

        // CALL RECURSIVE FUNCTION ON PROBLEM THAT YOU WANT TO SOLVE, RETURNING THE ANSWER
        return recurseDice(N, DP);
    }
}