package your_code;

import java.util.LinkedList;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue {

    private LinkedList<Integer> priorityll;  //other option is to initialize in declaration by making priorityll = new LinkedList<>()

    public MyPriorityQueue() {            //constructor; more explicit than "declaration"
        priorityll = new LinkedList<>();  //"initialization"
    }

    public void enqueue(int item) {    //O(N)
        int index = 0;

        for (int val : priorityll) {
            if (val > item) {
                priorityll.add(index, item);
                return;
            }
            index++;
        }
        priorityll.add(item);            //if it needs to be added at the end or if the linkedlist is empty
    }

    /**
     * Return and remove the largest item on the queue.
     */
    public int dequeueMax() {          //O(1)
        int last = priorityll.size() - 1;
        return priorityll.remove(last);
    }
}