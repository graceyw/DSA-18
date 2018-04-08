public class Problems {

    //Runtime: O(N)
    public static int leastSum(int[] A) {
        if (A.length == 0) return 0;

        int[] digitToCount = new int[10];  //because options are 0 -> 9
        for (int i = 0; i < A.length; i++) {
            digitToCount[A[i]]++;
        }

        int[] sorted = new int[A.length];

        int digit = 0;
        int indexOfSorted = 0;
        for (int count : digitToCount) {
            while (count != 0) {
                sorted[indexOfSorted] = digit;
                indexOfSorted++;
                count--;
            }
            digit++;
        }

        String sum1str = "";
        String sum2str = "";
        for (int i = 0; i < sorted.length; i++) {
            if (i % 2 == 0) {                //if i is even, so starting with index 0
                sum1str += sorted[i];
            } else {
                sum2str += sorted[i];
            }
        }
        if (sum2str.isEmpty()) {              //if sum2str is empty
            return Integer.parseInt(sum1str); //just return sum1str
        }
        return Integer.parseInt(sum1str) + Integer.parseInt(sum2str);
    }
}
