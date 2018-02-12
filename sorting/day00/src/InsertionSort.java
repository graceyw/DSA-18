
public class InsertionSort extends SortAlgorithm {
    /**
     * Use the insertion sort algorithm to sort the array
     *
     * Best-case runtime: O(N)?
     * Worst-case runtime: O(N^2)
     * Average-case runtime: O(N)?
     *
     * Space-complexity: O(1) because no copies of the array are made
     */
    @Override
    public int[] sort(int[] array) {
        for (int i=1; i < array.length; i++){
            int elem = i;
            while (array[elem] < array[elem-1] && elem > 0){
                array[elem] = array[elem-1];  //switch the 2 elems
                array[elem-1] = array[elem];  //switch the 2 elems
                elem--;
            }
        }
        return array;
    }
}
