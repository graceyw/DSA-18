package your_code;
import ADTs.StackADT;

import java.util.LinkedList;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {

    private LinkedList<Integer> ll;
    private LinkedList<Integer> copiedList;

    public MyStack() {
        ll = new LinkedList<>();
    }

    @Override
    public void push(Integer e) {
        ll.addFirst(e);
    }

    @Override
    public Integer pop() {
        Integer pop = ll.removeFirst();
        return pop;
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public Integer peek() {
        return ll.getFirst();
    }

    public Integer maxElement() {
        int max = Integer.MIN_VALUE;    // super small value
        for (int thing : ll){           // for thing in linkedlist, therefore stack
            if (thing > max){
                max = thing;
            }
        }
        return max;
    }
}
