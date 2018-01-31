# Day02 - `Linked Lists, Stacks, and Queues`

## Learning Goals

- Understand memory allocation of linked lists
- Understand the need and implementation of pointer based data structures
- Be able to analyze time complexities of linked lists

- Understand when to use LinkedList versus ArrayList
- Understand the difference between a stack and a queue
- Identify problems where stacks or queues can contribute to an effective solution.
- Implement a stack and a queue that uses `O(n)` space and has `O(1)` per-operation time complexity.

# Optional Resources

- In [Think DAST](http://greenteapress.com/thinkdast/thinkdast.pdf), read sections **4.1, 4.2, 5.4, and 5.5** which cover Linked Lists. Read section **6.6** which covers Stacks and Queues. Ignore the parts about "DFS", we'll learn about that later.
- The class [Google Drive](https://drive.google.com/drive/folders/1W8hPg5bVsUO5I9juJZdmYM5xYRnsIxIT?usp=sharing) has a ton of awesome resources from todays class. Included are two sets of lecture notes we wrote that you can refer to, powerpoint slides, and todays pset. Highly recommended you look through [this folder](https://drive.google.com/drive/folders/1MgFwOFICcBvi8hxBOAXQKWQZZ7OOgfa0?usp=sharing) if you are struggling with the assignment.

# Assignment

## Code

In this homework assignment, you will be implementing your own linked list, doubly-linked list, and pseudo priority queue. You will also augment the stack to support the `maxElement` operation. With each problem, we will add functionality to our classes to more closely match the real functionality of said data structures.

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

* Modify `MyStack` so that it supports: `public Integer maxElement()`. All operations (including `maxElement`) should still be constant time.
* Write a new class `MyPriorityQueue`, which supports `enqueue` and `dequeueMax`. This queue dequeues the largest element on the queue, rather than the element at the front of the queue. In this case, you will only be able to do one of the operations in O(1) time. The other operation will be O(N).
