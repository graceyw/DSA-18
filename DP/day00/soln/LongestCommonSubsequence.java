public class LongestCommonSubsequence {
    // DP[i, j] is the LCS of S1[i:] and S2[j:]
    private static int LCSrecurs(String S1, String S2, int i, int j, int[][] DP) {
        if (i == S1.length()) return 0;
        if (j == S2.length()) return 0;
        if (DP[i][j] != -1) return DP[i][j];
        int ans;
        if (S1.charAt(i) == S2.charAt(j)) {
            ans = 1 + LCSrecurs(S1, S2, i + 1, j + 1, DP);
        } else {
            // Guess: which character do we drop?
            ans = Math.max(LCSrecurs(S1, S2, i, j + 1, DP), LCSrecurs(S1, S2, i + 1, j, DP));
        }
        DP[i][j] = ans;
        return DP[i][j];
    }

    // Runtime: O(N*M), where N is length of S1, M length of S2
    // Space: O(N*M)
    public static int LCS(String S1, String S2) {
        int[][] DP = new int[S1.length()][S2.length()];
        for (int i = 0; i < S1.length(); i++) {
            for (int j = 0; j < S2.length(); j++) {
                DP[i][j] = -1;
            }
        }
        return LCSrecurs(S1, S2, 0, 0, DP);
    }
}
