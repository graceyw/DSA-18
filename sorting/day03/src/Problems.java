import java.util.LinkedList;

public class Problems {

    static void sortNumsBetween100s(int[] A) { //runtime: O(N+K) cause of countingsort
        for (int i=0; i<A.length; i++) {
            A[i] = A[i] + 100;           //make range between 0 -> 200 instead of -100 -> 100
        }
        CountingSort.countingSort(A);
        for (int i=0; i<A.length; i++) {
            A[i] = A[i] - 100;           //bring it back to original range
        }
    }

    /**
     * @param n the character number, 0 is the rightmost character
     * @return
     */
    private static int getNthCharacter(String s, int n) {
        return s.charAt(s.length() - 1 - n) - 'a';
    }

    /**
     * Use counting sort to sort the String array according to a character
     *
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByCharacter(String[] A, int n) {
        // Runtime: O(N)
        // Space: O(Nish)
        LinkedList<String>[] L = new LinkedList[26];     //26 = because just lowercase letters, not full ASCII which would be 256
        for (int i = 0; i < 26; i++)
            L[i] = new LinkedList<>();
        for (String s : A) {
            L[getNthCharacter(s,n)].add(s);               //Add s to the ll at the index of the char (using getNthCharacter)
        }
        int j = 0;                                        // index in A to place numbers
        for (LinkedList<String> list : L) {
            while (list.size() > 0) {                     //Put all numbers in the linked lists into A
                A[j] = list.pop();
                j++;
            }
        }
    }

    /**
     * @param stringLength The length of each of the strings in S
     */
    //Runtime: O(N*w)
    //Space: O(N)
    static void sortStrings(String[] S, int stringLength) {
        for (int i=0; i<stringLength; i++) {
            countingSortByCharacter(S,i);
        }
    }

    /**
     * @param A The array to count swaps in
     */

    public static int countSwaps(int[] A) {          //optional
        // TODO
        return 0;
    }
}
