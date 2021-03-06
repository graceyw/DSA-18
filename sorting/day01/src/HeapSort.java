public class HeapSort extends SortAlgorithm {
    int size;
    int[] heap;

    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Check children, and swap with larger child if necessary.
    // Corrects the position of element indexed i by sinking it.
    // Use either recursion or a loop to then sink the child
    public void sink(int i) {
        if (leftChild(i) >= size && rightChild(i) >= size) {                                   //if it has no children
            return;
        }
        if (leftChild(i) < size && rightChild(i) < size) {                                   //if it has 2 child nodes (both exist)
            if (heap[i] < heap[leftChild(i)] && heap[i] < heap[rightChild(i)]) {             //if parent > either child
                if (heap[leftChild(i)] > heap[rightChild(i)]) {                                //if left > right
                    int childIndex = leftChild(i);
                    swap(heap, i, childIndex);
                    sink(childIndex);                                                          //recursive moment!
                } else {                                                                       //can be >= bc we don't care which one switches if children are the same
                    int childIndex = rightChild(i);
                    swap(heap, i, childIndex);
                    sink(childIndex);                                                          //recursive moment!
                }
            }
            else if (heap[i] < heap[rightChild(i)]) {                                         //if parent < ONLY left node
                int childIndex = rightChild(i);
                swap(heap, i, childIndex);
                sink(childIndex);
            }
            else if (heap[i] < heap[leftChild(i)]) {                                          //if parent < ONLY right node
                int childIndex = leftChild(i);
                swap(heap, i, childIndex);
                sink(childIndex);
            }
        }
        else if (leftChild(i) < size) {                                                       //if only left node exists
            if (heap[i] < heap[leftChild(i)]) {                                               //if child > parent
                int childIndex = leftChild(i);
                swap(heap, i, childIndex);
                sink(childIndex);                                                             //recursive moment!
            }
        }
    }

    // Given the array, build a heap by correcting every non-leaf's position, starting from the bottom, then
    // progressing upward
    //Always O(N). Sinking from bottom so most of sinks are cheap (1)
    public void heapify(int[] array) {
        this.heap = array;
        this.size = array.length;

        for (int i=this.size / 2 - 1; i>=0; i--) {
            sink(i);                                                                //pretty simple
        }
    }

    /**
     * Best-case runtime:
     * Worst-case runtime:
     * Average-case runtime: NlogN         best sorting algorithms are all NlogN runtime (look up proof that says you can't do better)
     *
     * Space-complexity:
     */
    @Override
    public int[] sort(int[] array) {
        heapify(array);

        for (int i=size-1; i>0; i--) {  //don't actually call anything on A[i]. Just to make sure you do it the correct # of times.
            swap(array,0,i);
            size--;
            sink(0);
        }
        return heap;
    }
}