// Doing top-down approach
// Subproblem Definition: DP[i][j] = # of changes to A[0:i] to get to B[0:j]
// Guess: Replace? Delete? Insert?
// Recurrence Relation: DP[i][j] = min(dP[i][j]+1, DP[i][j-1]+1, DP[i-1][j]+1, DP[i-1][j-1]+1)
// Answer: DP(A.length)

public class EditDistance {

    public static int minEditDist(String a, String b) {
        int[][] DP = new int[a.length()][b.length()];     //initialize memo
        for (int i=0; i < DP.length; i++) {
            for (int j = 0; j < DP.length; j++) {
                DP[i][j] = -1;                            //set a special empty value
            }
        }
        return recurse(a,b,DP);                           //call recursive function on problem to solve
    }


    private static int recurse(String a, String b, int[][] DP) {

        if () {         // base cases

        }

        if (DP[a.length()][b.length()] != -1) return DP[a.length()][b.length()];     // check if already memoized; if so return that

        for (int i=1; i<a.length(); i++) {          // Recurrence Relation  //check for off by 1 error, might be better to start at 0 and check that not 0
            for (int j = 1; j<b.length(); j++) {
                int tempMin = Math.min(recurse(a.substring(0,i), b.substring(0,j-1),DP), recurse(a.substring(0,i-1), b.substring(0,j), DP));    //min(whole string, one less). Necessary to do 2 bc Math.min only takes 2 inputs
                DP[i][j] = 1 + Math.min(tempMin, recurse(a.substring(0,i), b.substring(0,j), DP));     //substring has exclusive ending index so check for off by 1 error
            }
        }

        // Update memo
        DP[a.length()][b.length()] = ;

        return 0;
    }
}
