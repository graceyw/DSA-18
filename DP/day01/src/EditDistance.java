// Doing top-down approach
// Subproblem Definition: DP[i][j] = # of changes to A[0:i] to get to B[0:j]
// Guess: Replace? Delete? Insert?
// Recurrence Relation: DP[i][j] = 1 + min(DP[i][j-1], DP[i-1][j], DP[i-1][j-1])
// Answer: DP[A.length][B.length]

public class EditDistance {

    public static int minEditDist(String a, String b) {
        if (a.equals(b)) return 0;

        int[][] DP = new int[a.length()+1][b.length()+1];     //initialize memo
        for (int i=0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                DP[i][j] = -1;                                //set a special empty value
            }
        }
        return recurse(0,0,a,b,DP);                         //call recursive function on problem to solve
    }


    private static int recurse(int i, int j, String a, String b, int[][] DP) {

        // BASE CASES
        if (i == a.length()) return b.length()-j;                 //EditDistance =          because you must insert
        if (j == b.length()) return a.length()-i;                 //EditDistance =          because you must delete

        // CHECK MEMO
        if (DP[i][j] != -1) return DP[i][j];     // if already memoized, return that

        //
        if (a.charAt(i) == b.charAt(j)) {
            int temp = recurse(i+1,j+1,a,b,DP);
            DP[i][j] = temp;
            return temp;
        }

        //If a change must be made (insert, delete, or replace):
        int tempMin = Math.min(recurse(i+1,j,a,b,DP), recurse(i,j+1,a,b,DP));                // Necessary to do 2 bc Math.min only takes 2 inputs
        DP[i][j] = 1 + Math.min(tempMin, recurse(i+1,j+1,a,b,DP));    //Update Memo    //substring has exclusive ending index so check for off by 1 error

        return DP[i][j];
    }
}