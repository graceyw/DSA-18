import java.util.*;

public class Problems {

    public static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            next = null;
        }
    }

    public static List<Integer> removeKDigits(int[] A, int k) {
        int size = A.length;   //this assumes that size == length ie list is full
        if (size == 0){
            throw new IndexOutOfBoundsException();
        }

        Stack<Integer> s = new Stack();
        for (int i: A) {                //for each thing in A
            while (s.size() != 0 && i < s.peek() && k > 0){
                s.pop();
                k--;
            }
            if (s.size() < A.length-k){
                s.push(i);
            }
        }
        LinkedList ll = new LinkedList<Integer>();
        while (s.size() != 0){
            ll.addFirst(s.pop());
        }
        return ll;
    }

    public static boolean isPalindrome(Node n) {
        if (n == null){
            return true;
        }
        Node x = n;
        int size = 0;
        while (x.next != null){
            x = x.next;
            size++;
        }
        Node tail = x;

        int middleIndex = size/2;

        Node currNode = n;
        for (int i=0; i < middleIndex; i++) {    //find index of middle node
            currNode = currNode.next;
        }
        Node middleNode = currNode;
        Node m2 = middleNode.next;
        for (int i = middleIndex; i < size; i++) {
            Node mTemp = m2.next;                  // new temp node after n2
            m2.next = middleNode;                  // redirect m2 pointer to middle
            middleNode = m2;                       // reassign middlenode to next node
            m2 = mTemp;                            // reassign m2 to next node
        }
        for (int i=0; i < middleIndex-1; i++) {
            if (n.val != tail.val){
                return false;
            }
            n = n.next;
            tail = tail.next;
        }
        return true;
    }

    public static String infixToPostfix(String s) {
        // TODO
        return null;
    }

}
