
public class InsertionSort extends SortAlgorithm {
    /**
     * Use the insertion sort algorithm to sort the array
     *
     * Best-case runtime: O(N) if it's small or already mostly sorted
     * Worst-case runtime: O(N^2)
     * Average-case runtime: O(N)
     *
     * Space-complexity: O(1) because no copies of the array are made
     */
    @Override
    public int[] sort(int[] array) {
        for (int i=1; i < array.length; i++){
            int elem = i;
            while (elem > 0 && array[elem] < array[elem-1]){
                swap(array, elem, elem-1);          //provided func that switches the two
                elem--;
            }
        }
        return array;
    }
}