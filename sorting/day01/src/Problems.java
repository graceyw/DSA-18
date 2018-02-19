import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Problems {

    private static double getMedian(List<Integer> A) {
        double median = (double) A.get(A.size() / 2);
        if (A.size() % 2 == 0)
            median = (median + A.get(A.size() / 2 - 1)) / 2.0;
        return median;
    }

    // Runtime of this algorithm is O(N^2). Sad! We provide it here for testing purposes
    public static double[] runningMedianReallySlow(int[] A) {
        double[] out = new double[A.length];
        List<Integer> seen = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int j = 0;
            while (j < seen.size() && seen.get(j) < A[i])
                j++;
            seen.add(j, A[i]);
            out[i] = getMedian(seen);
        }
        return out;
    }


    /**
     *
     * @param inputStream an input stream of integers
     * @return the median of the stream, after each element has been added
     */
    public static double[] runningMedian(int[] inputStream) {
        double[] runningMedian = new double[inputStream.length];
        PriorityQueue<Integer> aboveMedian = new PriorityQueue<>(11);
        PriorityQueue<Integer> belowMedian = new PriorityQueue<>(11, Collections.reverseOrder());   //by default in java PQs are min, so we say reverse to make it a max PQ

        if (inputStream.length == 0) {
            return runningMedian;
        }

        for (int med=0; med<inputStream.length; med++) {
            belowMedian.offer(inputStream[med]);

            if (belowMedian.size() > aboveMedian.size()+1) {
                aboveMedian.offer(belowMedian.poll());
            }
            if (! aboveMedian.isEmpty() && belowMedian.peek() > aboveMedian.peek()) {
                aboveMedian.offer(belowMedian.poll());
                belowMedian.offer(aboveMedian.poll());
            }

            if ((aboveMedian.size() + belowMedian.size()) % 2 == 0) {
                runningMedian[med] = (double)(aboveMedian.peek() + belowMedian.peek())/2;
            }
            else {
                runningMedian[med] = belowMedian.peek();
            }
        }
        return runningMedian;
    }
}