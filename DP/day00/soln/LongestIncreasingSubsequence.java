public class LongestIncreasingSubsequence {

    // DP[i] is the length of the LIS whose first element is A[i]
    private static int recurse(int[] A, int[] DP, int i) {
        if (DP[i] != 0) return DP[i];
        int ans = 1;
        for (int j = i + 1; j < A.length; j++) {
            if (A[j] > A[i]) ans = Math.max(ans, 1 + recurse(A, DP, j));
        }
        DP[i] = ans;
        return DP[i];
    }

    // Runtime: O(N^2)
    // Space: O(N)
    public static int LIS(int[] A) {
        int[] DP = new int[A.length];
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans = Math.max(recurse(A, DP, i), ans);
        }
        return ans;
    }
}
