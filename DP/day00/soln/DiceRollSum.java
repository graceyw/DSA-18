public class DiceRollSum {

    // Runtime: O(N)
    // Space: O(N)
    public static int diceRollSum(int N) {
        int[] DP = new int[N + 1];
        return diceRollRecurs(N, DP);
    }

    private static int diceRollRecurs(int i, int[] DP) {
        if (i < 0) return 0;
        if (i == 0) return 1;
        if (DP[i] != 0) return DP[i];
        int sum = 0;
        // Guess, what is the first roll? Could be 1-6
        for (int j = 1; j <= 6; j++) {
            sum += diceRollRecurs(i - j, DP);
        }
        DP[i] = sum;
        return DP[i];
    }
}
