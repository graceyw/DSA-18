import java.util.Arrays;

public class MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
     * Best-case runtime: O(N)
     * Worst-case runtime: O(Nlog(N))
     * Average-case runtime: O(Nlog(N))
     *
     * Space-complexity: O(Nlog(N)) because Nlog(N) copies are made
     */
    @Override
    public int[] sort(int[] array) {
        if (array.length <= INSERTION_THRESHOLD) {
            InsertionSort insertSort = new InsertionSort();
            return insertSort.sort(array);
        }
        if (array.length <= 1) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        left = sort(left);           //recursively call
        right = sort(right);         //recursively call
        array = merge(left,right);
        return array;
    }

    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     */
    public int[] merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int index = 0;
        int[] merged = new int[a.length + b.length];      //create new array of length a+b

        while (i<a.length && j<b.length) {                //pop out when one of the lengths runs out
            if (a[i] < b[j]) {
                merged[index] = a[i];
                i++;
                index++;
            }
            else {                              //handles if b[j] > a[i] and if a[i]==b[j]
                merged[index] = b[j];           //if they're the same it doesn't matter which one gets put in first
                j++;
                index++;
            }
        }
        while (i < a.length) {          //if we get here it's because the other while loop ended, so at least 1 pointer reached the end of an array
            merged[index] = a[i];       //add the remaining things in the other array to the end
            i++;
            index++;
        }
        while (j < b.length) {
            merged[index] = b[j];
            j++;
            index++;
        }
        return merged;
    }
}