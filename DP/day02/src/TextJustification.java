import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TextJustification {

    /*
    w is an array of strings in order
    m is the maximum length of a line
    returns a list of the indices of the first word of each line of justified text

    Subproblem: w[i:]
    Guess: Where to start 2nd line
    Recurrence Relation: DP[i] = min(
    */
    private static double cost(String[] words, int lo, int hi, int m) {
        if (hi <= lo)
            throw new IllegalArgumentException("Hi must be higher than Lo");
        int length = hi-lo-1; // account for spaces;
        for (int i = lo; i < hi; i++) {
            length += words[i].length();
        }
        if (length > m)
            return Double.POSITIVE_INFINITY;
        return Math.pow(m-length, 3);
    }


    public static List<Integer> justifyText(String[] w, int m) {
        

        return null;
    }

//    public static ArrayList<String> solve(ArrayList<String> w, int m){
//        int[] DP = new int[w.size()];
//
//        if (total_length(l) > m) {
//            cost[l] =
//        }
//        int cost = ;
//
//        for (int i = w.size(); i<=0; i--) {
//            for (int j=i+1; j<w.size()+1; j++) {
//                DP[i] = DP[j] + cost(i,j);
//            }
//        }
//
//        return new ArrayList<>();
//    }
}