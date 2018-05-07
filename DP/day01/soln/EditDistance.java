import static java.lang.Math.*;


public class EditDistance {

    //Bottom up edit distance
    public static int minEditDistBottomUp(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        //Fill in DP array
        for (int i = 0; i <= a.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= b.length(); i++) {
            dp[0][i] = i;
        }


        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[a.length()][b.length()];
    }


    //Top down edit distance
    public static int minEditDist(String a, String b){
        if(a.length()==0){
            return b.length();
        }

        if(b.length() == 0){
            return a.length();
        }

        int[][] memo = new int[a.length() + 1][b.length() + 1];

        for(int i = 0; i <= a.length(); i++){
            for(int j = 0; j <= b.length();j++){
                memo[i][j] = -1;
            }
        }

        return minEditDistRecurse(a, b, memo);
    }

    public static int minEditDistRecurse(String a, String b, int[][] memo){
         if(a.length()==0){
            return b.length();
        }

        if(b.length() == 0){
            return a.length();
        }

        //Already in memo
        if(memo[a.length()][b.length()] != -1){
            return memo[a.length()][b.length()];
        }

        //Guess
        int del = 1;
         if(a.charAt(a.length()-1)==b.charAt(b.length()-1)){
             del = 0;
         }
        int diag = minEditDistRecurse(a.substring(0,a.length()-1), b.substring(0, b.length()-1), memo)+del;
        int horiz = minEditDistRecurse(a.substring(0,a.length()-1), b, memo)+1;
        int vert = minEditDistRecurse(a, b.substring(0, b.length()-1), memo)+1;
        int res = min(horiz, vert);
        res = min(res, diag);
        memo[a.length()][b.length()] = res;
        return res;
    }

}
