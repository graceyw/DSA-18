public class SplitCoins {

    private static int bestChoice(int choice1, int choice2, int totalSum) {
        double half = totalSum / 2.0;
        double error1 = Math.abs(choice1 - half);
        double error2 = Math.abs(choice2 - half);
        if (error1 < error2)
            return choice1;
        return choice2;
    }

    //Bottom up split coins
    public static int splitCoins(int[] coins) {
        int s = 0;
        for (int c : coins)
            s += c;
        int[][] DP = new int[coins.length + 1][s + 1];
      // DP[i, j] is the optimal final value in the left pile
        // assuming coins[:i] have already been placed in some configuration that
        // resulted in j value in the left pile.

        // The recurrence relation is DP[i, j] = min(DP[i+1, j], DP[i+1, j+coins[i]]),
        // Because we can chose to either place a coin in the left pile, or place it in the
        // right pile.

        for (int i = coins.length; i >= 0; i--) {
            for (int j = 0; j <= s; j++) {
                int answer = -1;
                 // some subproblems are impossible. (Ie, DP[0, 10] can't happen because if we have
                // placed 0 coins, then how can there be value 10 in the left pile? In this case,
                // we store -1 in DP)
                if (i == coins.length)
                    answer = j;
                else if (j + coins[i] <= s)
                    answer = bestChoice(DP[i + 1][j], DP[i + 1][j + coins[i]], s);
                DP[i][j] = answer;
            }
        }
        int left = DP[0][0];
        int right = s - left;
        return Math.abs(left - right);
    }


    //Top down split coins
    public static int splitCoinsTopDownRecurs(int[] coins, int i, int j, int totalSum, int[][] memo) {
        //Base
        if (i==coins.length)
            return j;
        //Already memoed
        if (memo[i][j] != -1)
            return memo[i][j];
        //Guess left pile or right pile
        int placeRight = splitCoinsTopDownRecurs(coins, i+1, j, totalSum, memo);
        int placeLeft = splitCoinsTopDownRecurs(coins, i+1, j+coins[i], totalSum, memo);
        memo[i][j] = bestChoice(placeLeft, placeRight, totalSum);
        //fill in memo
        return memo[i][j];
    }

    public static int splitCoinsTopDown(int[] coins) {
        //Total sum
        int s = 0;
        for (int c : coins)
            s += c;

        //Fill memo with -1
        int[][] memo = new int[coins.length][s+1];
        for (int i = 0; i < coins.length; i++)
            for (int j = 0; j <= s; j++)
                memo[i][j] = -1;

        return Math.abs(s - 2*splitCoinsTopDownRecurs(coins, 0, 0, s, memo));
    }
}
