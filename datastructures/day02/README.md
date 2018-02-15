# Day02 - `Linked Lists, Stacks, and Queues`

# Learning Goals

- Understand memory allocation of linked lists
- Understand the need and implementation of pointer based data structures
- Be able to analyze time complexities of linked lists
- Understand when to use LinkedList versus ArrayList
- Understand the difference between a stack and a queue
- Identify problems where stacks or queues can contribute to an effective solution.
- Implement a stack and a queue that uses `O(n)` space and has `O(1)` per-operation time complexity.

# Resources

- In [Think DAST](http://greenteapress.com/thinkdast/thinkdast.pdf), read sections **4.1, 4.2, 5.4, and 5.5** which cover Linked Lists. Read section **6.6** which covers Stacks and Queues. Ignore the parts about "DFS", we'll learn about that later.

- Our lecture notes on Linked Lists and Stacks/Queues are [here](https://drive.google.com/open?id=19wmaQ2eLntO9mXKmJzc_b7luxj_7d603v0GXnZc_P18).

- Our slides on [LLs](https://docs.google.com/presentation/d/1_5Uz06Yw2P-CdXoP-j_D_RIVlP_y89wv7xjHdx4vzZ8/edit?usp=sharing) and [S+Q](https://docs.google.com/presentation/d/1EBnTBGXLrpecftsyOScBp8OPW4bcv5hdMZol789w33o/edit?usp=sharing)s.

- Notes from UC Berkeley on [Linked Lists](https://drive.google.com/open?id=1czCHlwIhvMl-KkZon1hTiA6relpjfxkr) and [Stacks/Queues](https://drive.google.com/open?id=1NbfPaMdlokDTGlGVL20vynXECxfe0OfJ)

# Assignment

## Code

In this homework assignment, you will be implementing your own doubly-linked list and pseudo priority queue. You will also augment the stack to support the `maxElement` operation. With each problem, we will add functionality to our classes to more closely match the real functionality of said data structures.

### Provided for you

1. The internal `Node` class: its constructor takes in the Chicken, as well as references to the `prev` and `next` nodes.
1. Some internal variable you probably want to keep track of in the `LinkedList`: the `head` and `tail` `Node`s, and the `size` of the `LinkedList`.

### Your code

Ben would like to start a farm that only contains chickens. He wants your help in creating an `LinkedList` to store these chickens in.

You will be provided a `Chicken` class that your `MyLinkedList` will *exclusively* store. Each `Chicken` has the following properties:
```java
public class Chicken {
    String name;
    int age;
    String color;
}
```
The tests you will be running on your `MyLinkedList` class will be using this `Chicken` class.

1. Implement an empty constructor. Initialize `head`, `tail`, and `size`.

    `public MyLinkedList()`

2. Implement a method called `addLast` that will add a `Chicken` to the end of your `MyLinkedList`. Remember to consider the special case where `size` is 0.

    `public void addLast(Chicken c)`

3. Sometimes a chicken will confuse the beginning of the line with the end of the line, and Ben needs to be able to deal with this. Implement `addFirst` that will allow a chicken to be added to the front of the `LinkedList`. Remember to consider the special case where `size` is 0.

    `public void addFirst(Chicken c)`

4. Can we inspect a chicken in our `MyLinkedList`? Implement a method called `get` that will return a `Chicken` given the index of the `Chicken`. Make sure to check that `index` is valid.

    `public Chicken get(int index)`

5. Some chickens might leave the farm for various reasons. LinkedLists have special case O(1) deletes off the front and back. Implement `removeFirst` and `removeLast`, and make sure to return them so Ben can "deal" with them. Remember to consider the special cases where `size` is 0 or 1.

    `public Chicken removeFirst()`

    `public Chicken removeLast()`

6. Chickens might leave in any order. If a chicken in the middle leaves, we want to update our `LinkedList` pointers so that the `Node` before the removed chicken points to the `Node` after the removed `Chicken`. Return the removed `Chicken` so we can "deal" with it. Remember to consider the special cases where `index=0` or `index=size-1`.

    `public Chicken remove(int index)`


Test your DLL by running `MyLinkedListTest.java`. Make all test cases pass.

### Stack

Take a look at our implementation of `MyStack`. Note that it:

- heavily relies of the use of linked lists
- uses `O(n)` space-complexity
- has each of the its four functions (`push`, `pop`, `peek`, and `isEmpty`) take constant `O(1)` time.

Take the time to think through why each of these are they way they are.

### Queue

Take a look at our implementation of `MyQueue`. Note that it:

- heavily relies on the use of linked lists
- use `O(n)` space-complexity
- have each of the its four functions (`enqueue`, `dequeue`, `isEmpty`, `front`) take constant `O(1)` time.

Take the time to think through why each of these are they way they are.

### Augmentation

* Modify `MyStack` so that it supports: `public Integer maxElement()`. This function returns the largest element currently on the stack. All operations (including `maxElement`) should still be constant `O(1)` time per operation. For example:

```java
MyStack s = new MyStack();
s.push(4);
s.push(1);
s.push(5);
System.out.println(s.maxElement()); // this should print 5
s.pop(); // this pops the 5 off the stack
System.out.println(s.maxElement()); // this should print 4, since it is the largest remaining element on the stack
```

* Write a new class `MyPriorityQueue`, which supports `enqueue` and `dequeueMax`. This queue's `dequeueMax` function dequeues the largest element on the queue, rather than the element at the front of the queue. In this case, you will only be able to do one of the operations in O(1) time. The other operation will be O(N). For example:

```java
MyPriorityQueue q = new MyPriorityQueue();
q.enqueue(6);
q.enqueue(2);
q.enqueue(4);
System.out.println(q.dequeueMax()); // this should print 6, and remove the 6 from the queue
System.out.println(q.dequeueMax()); // this should print 4, and remove the 4 from the queue
q.enqueue(3); // 3 is now the largest element on the queue
System.out.println(q.dequeueMax()); // this should print 3, and remove the 3 from the queue
```
