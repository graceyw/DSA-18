import java.util.LinkedList;

public class RadixSort {

    /**
     * @param n the digit number, 0 is least significant
     * @return
     */
    private static int getNthDigit(int number, int base, int n) {
        return number / ((int) Math.pow(base, n)) % base;
    }


    /**
     * Use counting sort to sort the integer array according to a digit
     *
     * @param b The base used in radix sort
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByDigit(int[] A, int b, int n) {
        LinkedList<Integer>[] L = new LinkedList[b];
        for (int i = 0; i < b; i++)
            L[i] = new LinkedList<>();
        for (int i : A) {
            L[getNthDigit(i,b,n)].add(i);         //Extract relevant digit from i, add i to the corresponding Linked List
        }
        int j = 0;                                //index in A to place numbers
        for (LinkedList<Integer> list : L) {
            while (list.size() > 0) {             //Put all numbers in the linked lists into A
                A[j] = list.pop();
                j++;
            }
        }
    }

    /**
     * Good for really large arrays, and arrays where you have a particular range you know everything's going to be in
     * Requires data structure that you can iterate through digits/sigfigs; floats are not good
     * Not helpful for set of ints that are super spaced out (i.e. 0 and 13,000,000,000) bc you have to make an array of that crazy size only to use like 2 indices
     *
     * Runtime: O(n+b(w))
     * Space: O(b*n) because array of ll is b
     *
     * n: length of array
     * w: word length of integers A in base b (equal to log base b of k (log_b k) )
     *
     * @param b The base to use for radix sort
     */
    static void radixSort(int[] A, int b) {
        // Calculate the upper-bound for numbers in A
        int k = A[0] + 1;
        for (int i = 1; i < A.length; i++)
            k = (A[i] + 1 > k) ? A[i] + 1 : k;                // "?" is a ternary operator. Means if (stuff in paran() is true), make k the thing after the ? mark, otherwise make k=k
        int w = (int) Math.ceil(Math.log(k) / Math.log(b));   // w = log base b of k, word length of numbers
        for (int i=0; i<w; i++) {                             //Perform radix sort
            countingSortByDigit(A,b,i);
        }
    }

}
