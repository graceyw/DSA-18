# Class Notes: Linked Lists, Stacks, and Queues
## Tuesday 1.30.18

#### Linked Lists

Unlike with arraylists, no need to resize!

public class Node(){
  int data;
  Node next;
  Node prev;

  Node n1 = new Node(2);
  Node n2 = new Node(3);
  Node n3 = new Node(7);
}

Traverse a Linked List and print each node's item:

while (head != null){
  print(head)
  head = head.next
}

public class LinkedList(){
  Node head, tail;
  int size;

  add(int a){
    Node newN = new Node a);
    if (tail != null){
      tail.next = newN;
    }
  }
}

#### Stacks
LIFO: Last in first out (can only add and remove off the top of the stack,
like a stack of books)

push(); // add an element to stack
pop(); // removing top element from stack
peek(); // looking at/getting top element of stack

#### Queues
FIFO: First in first out (can only add from the bottom and delete from top,
like waiting in a line for a roller coaster)

enqueue(); // add to the bottom of the queue
dequeue(); // delete off the top of the queue
front(); // look at element that's about to be dequeued (top)
