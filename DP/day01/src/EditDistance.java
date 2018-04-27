// Doing top-down approach
// Subproblem Definition: DP[i][j] = # of changes to A[0:i] to get to B[0:j]
// Guess: Replace? Delete? Insert?
// Recurrence Relation: DP[i][j] = 1 + min(DP[i][j-1], DP[i-1][j], DP[i-1][j-1])
// Answer: DP[A.length][B.length]

public class EditDistance {

    public static int minEditDist(String a, String b) {
        int[][] DP = new int[a.length()+1][b.length()+1];     //initialize memo
        for (int i=0; i < DP.length-1; i++) {
            for (int j = 0; j < DP.length-1; j++) {
                DP[i][j] = -1;                             //set a special empty value
            }
        }
        return recurse(a,b,DP);                 //call recursive function on problem to solve
    }


    private static int recurse(int i, int j, String a, String b, int[][] DP) {

        // BASE CASES
        if (i == a.length()) return j;                 //EditDistance =          because you must insert
        if (j == b.length()) return i;                 //EditDistance =          because you must delete

        // CHECK MEMO
        if (DP[i][j] != -1) return DP[i][j];     // if already memoized, return that


        //If a change must be made (insert, delete, or replace):
        int tempMin = Math.min(DP[i+1][j],DP[i][j+1]);                // Necessary to do 2 bc Math.min only takes 2 inputs
        DP[i][j] = 1 + Math.min(tempMin, DP[i+1][j+1]);    //Update Memo    //substring has exclusive ending index so check for off by 1 error
        

        //
        if (a[a.length()].equals(b.(b.length()))) {       //check if A[0:i-1] == B[0:j] bc substring (inclusive,exclusive]
            DP[a.length()][b.length()] = DP[a.length()][b.length()+1];
        }
        else if (a.substring(0,a.length()+1).equals(b.substring(0,b.length()))) {  //check if A[0:i] == B[0:j-1] bc substring (inclusive,exclusive]
            DP[a.length()][b.length()] = DP[a.length()-1][b.length()];
        }
        else if (a.substring(0,a.length()).equals(b.substring(0,b.length()))) {    //check if A[0:i-1] == B[0:j-1] bc substring (inclusive,exclusive]
            DP[a.length()][b.length()] = DP[a.length()-1][b.length()-1];
        }

//        for (int i=0; i<a.length(); i++) {          // Recurrence Relation  //check for off by 1 error, might be better to start at 0 and check that not 0
//            for (int j=0; j<b.length(); j++) {
//                if (a.substring(0,i).equals(b.substring(0,j+1))) {       //check if A[0:i-1] == B[0:j] bc substring (inclusive,exclusive]
//                    DP[i][j] = DP[i][j-1];
//                }
//                else if (a.substring(0,i+1).equals(b.substring(0,j))) {  //check if A[0:i] == B[0:j-1] bc substring (inclusive,exclusive]
//                    DP[i][j] = DP[i-1][j];
//                }
//                else if (a.substring(0,i).equals(b.substring(0,j))) {    //check if A[0:i-1] == B[0:j-1] bc substring (inclusive,exclusive]
//                    DP[i][j] = DP[i-1][j-1];
//                }
//                //If a change must be made (insert, delete, or replace):
//                int tempMin = Math.min(recurse(a.substring(0, i), b.substring(0, j - 1), DP), recurse(a.substring(0, i - 1), b.substring(0, j), DP));    //min(whole string, one less). Necessary to do 2 bc Math.min only takes 2 inputs
//                DP[i][j] = 1 + Math.min(tempMin, recurse(a.substring(0, i), b.substring(0, j), DP));    //Update Memo    //substring has exclusive ending index so check for off by 1 error
//            }
//        }
        return DP[a.length()][b.length()];
    }
}