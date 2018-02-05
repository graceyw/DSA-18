## Nick's Frustration-Free 6 Steps to Software Dev
### February 2nd, 2018

1. Understand the question
2. Manually work through an example
3. Distill what you did. Keep in mind runtimes.
4. Eduge cases!
5. Pseudocode
6. Review code step-by step to make sure each is executed right.

Given the head node, reverse a linked list. Return the new head node.
O(N) time and 0(1) space.

public reverseList(head){
  while (head){
    curr = head
    curr.prev = previousNode   //save prev pointer
    curr.prev = curr.next      //set prev pointer to next pointer
    curr.next = previousNode   //set next pointer to saved previous pointer
  }
}

Then check that your runtime matches the req.

### If you don't know where to go...
Brute force it!
