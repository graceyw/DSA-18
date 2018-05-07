import java.util.Arrays;

public class BalloonPopping {

    public static int maxPoints(int[] B) {
        // For NINJAS/Jingyi:
        // First, pad the array with 1s on each side, call this array `nums`
        // DP[i][j] = max coins in nums[i:j] (bounds inclusive)
        // Look at the hints in the readme. The idea is that you memoize the "payoff" of a given subarray: nums[i:j],
        // inclusive. We "guess" what the index of the last balloon we pop is: `k`. We guess all possible values of k in
        // the range [i, j] Then, we have our recurrence relation:
        // DP[i][j] = max([nums[k] * nums[i-1] * nums[j+1] + DP[i][k-1] + DP[k+1][j] for k in range(i, j + 1)])
        // Finally, this solution depends on the smallest subarray subproblems being solved first, so instead of
        // directly iterating over i, and j, we iterate `diff` from [0, N], and then compute j = i + diff.


        //Time(N^3)
        //Space(N^2)

        int N = B.length;
        int[] nums = new int[N+2];
        nums[0] = 1;
        nums[B.length+1] = 1;
        System.arraycopy(B, 0, nums, 1, N);

        int[][] DP = new int[N+2][N+2]; // DP by default is filled with 0

        for(int diff = 0; diff < N; diff++) {
            for(int i = 1; i < N + 1 - diff; i++){
                int j = i + diff; // inclusive
                int max = Integer.MIN_VALUE;
                for (int k = i; k < j + 1; k++) {
                    max = Math.max(max,
                            nums[k] * nums[i-1] * nums[j + 1] + DP[i][k-1] + DP[k+1][j]
                            );
                }

                DP[i][j] = max;
            }
        }
        return DP[1][N];
    }
}

