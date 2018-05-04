public class WeightedIntervals{

    public static int BU(int[] start, int[] end, int[] value){
        // Step 1
        int[] DP = new int[start.length+1];
        // Step 2
        DP[start.length] = 0;

        // Step 3
        for(int i = start.length - 1; i>=0; i--){
            // Step 4 + 5
            int k = i + 1;
            while (k < start.length && start[k] < end[i]) k++;
            int includedValue = DP[k] + value[i];
            DP[i] = Math.max(DP[i+1], includedValue);
        }
        // Step 6
        return DP[0];
    }

    // Step 3
    private static int recurse(int i, int[] start, int[] end, int[] value, int[] DP) {
        // Step 4
        if(DP[i] != -1) return DP[i];
        // step 5
        int k = i + 1;
        while (k < start.length && start[k] < end[i]) k++;
        int answer = Math.max(
                recurse(i + 1, start, end, value, DP),
                recurse(k, start, end, value, DP) + value[i]
        );
        // step 6
        DP[i] = answer;
        return DP[i];
    }

    public static int TD(int[] start, int[] end, int[] value){
        // Step 1
        int[] DP = new int[start.length + 1];
        for (int i = 0; i < DP.length; i++) {
            DP[i] = -1;
        }
        // Step 2
        DP[start.length] = 0;
        // Step 7
        return recurse(0, start, end, value, DP);
    }

}
