import java.util.LinkedList;
import java.util.List;

public class TextJustification {

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

    public static List<Integer> justifyTextBU(String[] w, int m) {

        // Steps 1 and 2. Store a memo keep track of justification costs (DP).
        // Use lineBreaks to store where lines starting at a given index end.
        double[] DP = new double[w.length + 1];
        DP[w.length] = 0;
        int[] lineBreaks = new int[w.length];
        lineBreaks[w.length-1] = w.length;

        for (int i = w.length-1; i >= 0; i--) { // Step 3
            // Step 4. Try all line breaks for first line
            int endLine = i+1;
            double lowest_cost = Double.POSITIVE_INFINITY;
            for (int j = i+1; j <= w.length; j++) {
                double c = cost(w, i, j, m) + DP[j];
                if (c < lowest_cost) {
                    lowest_cost = c;
                    endLine = j;
                }
            }
            // Step 5
            DP[i] = lowest_cost;
            lineBreaks[i] = endLine;
        }

        // Step 6. It's a little weird b/c the answer to the original problem is not one of our subproblems.
        // We use the information in lineBreaks to, knowing the first line starts at w[0], iterate to the start of the
        // next line until we hit the end of w.
        int index = 0;
        List<Integer> breaks = new LinkedList<>();
        while (index < w.length) {
            breaks.add(index);
            index = lineBreaks[index];
        }
        return breaks;
    }

    // Step 3
    private static double justifyRecurs(String[] w, int m, int i, double[] DP, int[] lineBreaks) {
        // Step 4
        if (DP[i] >= 0)
            return DP[i];
        // Step 5
        int endLine = i+1;
        double lowest_cost = Double.POSITIVE_INFINITY;
        for (int j = i+1; j <= w.length; j++) {
            double c = cost(w, i, j, m) + justifyRecurs(w, m, j, DP, lineBreaks);
            if (c < lowest_cost) {
                lowest_cost = c;
                endLine = j;
            }
        }
        // Step 6
        DP[i] = lowest_cost;
        lineBreaks[i] = endLine;
        return DP[i];
    }

    public static List<Integer> justifyTextTD(String[] w, int m) {
        // Step 1
        double[] DP = new double[w.length + 1];
        for (int i = 0; i < DP.length; i++)
            DP[i] = -1;
        // Step 2
        DP[w.length] = 0;
        int[] lineBreaks = new int[w.length];
        lineBreaks[w.length-1] = w.length;

        // Step 7. Again, a little weird b/c what justifyRecurs returns is not what we want to return.
        justifyRecurs(w, m, 0, DP, lineBreaks);

        int index = 0;
        List<Integer> breaks = new LinkedList<>();
        while (index < w.length) {
            breaks.add(index);
            index = lineBreaks[index];
        }
        return breaks;
    }

}