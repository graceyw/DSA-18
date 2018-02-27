import java.util.Collections;

public class CountingSort {

    /**
     * Use counting sort to sort positive integer array A.
     * Runtime: O(N+K)
     * Space: O(K)
     *
     * k: maximum element in array A
     */
    static void countingSort(int[] A) {         //void means it doesn't return anything; just sorts the array
        int k=0;                                //only works for array of pos ints
        for (int i=1; i<A.length-1; i++) {
            if (A[i] > A[i-1] && A[i] > k) {
                k = A[i];                       //make k the max in array
            }
        }
        int[] counts = new int[k+1];            //initialize new array of size k+1 (so there's a index for each possible entry)
        for (int i=0; i<A.length; i++) {
            counts[A[i]]++;                     //increase count at index of corresponding num
        }
        int i=0;
        for (int j=0; j<k+1; j++) {
            while (counts[j]>0) {
                A[i] = j;
                counts[j]--;
                i++;
            }
        }
    }
}
