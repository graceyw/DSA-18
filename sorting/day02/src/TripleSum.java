//Runtime: O(N^2)
//Space: O(N) (just create a hashmap)

import java.util.Arrays;
import java.util.HashSet;

public class TripleSum {

    static int tripleSum(int arr[], int sum) {
        Arrays.sort(arr);                             //O(NlogN) but we're doing the whole deal in O(N^2) so doesn't matter

        HashSet<Integer> nums = new HashSet<>();      //a set is a map w/o the values
        int triples = 0;
        for (int elem : arr) {
            int smaller = sum - elem;
            for (int key : nums) {
                if (smaller == 2*key) {                   //avoiding using elem twice in the same pair (bc there are no duplicates)
                    continue;                             //pop out to looking at the next elem in the for loop
                }
                else if (nums.contains(smaller-key)) {
                    triples++;
                }
            }
            nums.add(elem);                             //add elem to the set at the end so the loop doesn't count itself
        }
        return triples/2;
    }
}
