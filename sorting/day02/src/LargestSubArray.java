// Runtime: O(N) (faster than O(N^2))
// Space Complexity: O(N) (just create a hashmap)

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

// check the sum at each individual index, in increasing order. Then you iterate through and check
public class LargestSubArray {
    static int[] largestSubarray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int biggest = 0;
        int[] output = new int[]{0,0};

        for (int i=0; i<nums.length; i++) {
            if (! map.containsKey(sum)) {                        //if map doesn't already contain sum
                map.put(sum,i);                                  //put that sum and its index in the map
            }
            else if (biggest < i-map.get(sum)){                  //comparing to first time you saw index, which is stored in hashmap
                biggest = i-map.get(sum);
                output = new int[]{map.get(sum),i-1};
            }
            if (nums[i] == 0) {
                sum -= 1;        //make the 0's into -1's
            }
            else {
                sum += nums[i];                                  //works because you want to start at 0
            }
        }
        if (! map.containsKey(sum)) {                        //if map doesn't already contain sum
            map.put(sum,nums.length-1);                                  //put that sum and its index in the map
        }
        else if (biggest < nums.length-1-map.get(sum)){                  //comparing to first time you saw index, which is stored in hashmap
            biggest = nums.length-1-map.get(sum);
            output = new int[]{map.get(sum),nums.length-1};
        }
        return output;
    }
}
