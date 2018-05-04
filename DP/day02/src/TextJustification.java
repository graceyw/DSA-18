import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TextJustification {

    private static double cost(String[] words, int lo, int hi, int m) {
        /*
        m is max length of a line
        Returns cost of the line from words[lo,hi] including lo excluding hi
        */
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

    /*
    w is an array of strings in order
    m is the maximum length of a line
    returns a list of the indices of the first word of each line of justified text

    Subproblem: w[i:]
    Guess: Where to start 2nd line with minimum total cost (j, where i+1 <= j < w.size()+1
    Recurrence Relation: DP[i] = min((DP[j] + cost(line from i to j)) for j in range(i+1,w.length+1)) <- basically python syntax, given in MIT video lecture in README
    */
    public static List<Integer> justifyText(String[] w, int m) {
        //Initialize memo
        double[] DP = new double[w.length+1];
        for (int i=0; i<DP.length; i++) {
            DP[i] = Double.POSITIVE_INFINITY;
        }
        int[] nextBreak = new int[w.length+1];

        //Store base case in memo
        DP[w.length] = 0;

        //Solving and storing answers to subproblems in nextBreak (DP is used to store costs and thereby determine next breaks)
        for (int i = w.length; i >= 0; i--) {
            for (int j=i+1; j < w.length+1; j++) {
                if (DP[j] + cost(w, i, j, m) < DP[i]) {     //minimizing total cost
                    DP[i] = DP[j] + cost(w, i, j, m);       //will work bc DP[i] is decreasing from infinity with each loop
                    nextBreak[i] = j;                       //if DP[i] just got reassigned, you know the nextBreak is just j
                }
            }
        }

        ArrayList<Integer> breaks = new ArrayList<>();
        int index = 0;
        while (index < w.length) {
            breaks.add(index);
            index = nextBreak[index];
        }

        //Return answer to original problem
        return breaks;
    }

}