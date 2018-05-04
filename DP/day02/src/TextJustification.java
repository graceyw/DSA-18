import java.util.ArrayList;
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
    public static ArrayList<String> solve(ArrayList<String> w, int m){
        int[] DP = new int[w.size()];

        if (total_length(l) > m) {
            cost[l] =
        }
        int cost = ;

        for (int i = w.size(); i<=0; i--) {
            for (int j=i+1; j<w.size()+1; j++) {
                DP[i] = DP[j] + cost(i,j);
            }
        }


        return new ArrayList<>();
    }
}