/*
Data Structures and Algorithms
Day 02: LinkedLists, Stacks & Queues
Gracey Wilson
*/

package your_code;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Chicken val;
        Node prev;
        Node next;

        private Node(Chicken d, Node prev, Node next) {
            this.val = d;
            this.prev = prev;
            this.next = next;
        }

        private Node(Chicken d) {
            this.val = d;
            prev = null;
            next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Chicken c) {
        addLast(c);
    }

    public Chicken pop() {
        return removeLast();
    }

    public void addLast(Chicken c) {
        Node new_node;
        if (size == 0){      // if linkedlist is empty/size=0
            new_node = new Node(c,null,null);
            head = new_node;
            tail = head;
            size++;
        }
        else{
            new_node = new Node(c,tail,null);
            tail.next = new_node;
            tail = new_node;
            size++;
        }
    }

    public void addFirst(Chicken c) {
        Node new_node;
        if (size == 0){
            new_node = new Node(c,null,null);
            head = new_node;
            tail = new_node;
            size++;
        }
        else{
            new_node = new Node(c,null,head);
            head.prev = new_node;   //change pointers of old head?
            head = new_node;        //make new_node the head
            size++;
        }
    }

    public Chicken get(int index) {
        if (size <= index || index < 0){
            throw new IndexOutOfBoundsException();   //if here user made a mistake
        }
        int count = 0;
        Node curr_node = head;
        while (count < size){
            if (count == index){
                return curr_node.val;
            }
            count++;
            curr_node = curr_node.next;
        }
        throw new RuntimeException();  //if we get here I made a mistake
    }

    public Chicken remove(int index) {
        int count = 0;
        Node curr_node = head;
        while (count < size){
            if (count == index){
                if (index == 0){
                    return removeFirst();
                }
                else if (index == size-1){
                    return removeLast();
                }
                else if (size > 1){
                    curr_node.next.prev = curr_node.prev;  // have to reference node itself
                    curr_node.prev.next = curr_node.next;
                    size--;
                    return curr_node.val;
                }
            }
            count++;
            curr_node = curr_node.next;
        }
        return null;
    }

    public Chicken removeFirst() {
        if (head == null){    // if size = 0
            return null;
        }
        else if (size == 1){    // if head is only node
            Chicken saved = head.val;
            head = null;
            tail = null;
            size = 0;
            return saved;
        }
        else{                         // list of size > 1
            Chicken saved = head.val;
            head = head.next;
            head.prev = null;
            size--;
            return saved;
        }
    }

    public Chicken removeLast() {
        if (head == null){
            return null;
        }
        else if (size == 1) {    // if head is only node
            Chicken saved = head.val;
            head = null;
            tail = null;
            size = 0;
            return saved;
        }
        else {
            Chicken saved = tail.val;
            tail = tail.prev;
            tail.next = null;
            size--;
            return saved;
        }
    }
}