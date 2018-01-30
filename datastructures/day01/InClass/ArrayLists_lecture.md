# Class Notes: Array Lists
### Friday 1.26.18

"Stack overflow" is when you use more than your allotted amount of memory.
Can't delete memory you've already allocated.

Arrays tend to be pretty big. Don't always want to make new ones by hand.

class ArrayList(){
  int[] A = {1,2}
  int size
  public void add(){
    int[]B = new int[A.lenth + 1]
    System.arraycopy(A,B)
    B[size] = ;
    A=B
    size++     //iterate on the size
  }
}

Runtime: O(N) because of arraycopy.

#### Then
we can add functionality by checking the current size before changing it.

class ArrayList(){
  int[] A = {1,2}
  int size
  public void add(){
    if (size == A.length){
      grow()
    }
    A[size] = ;
    size++      //iterate on the size which means go to the next element in the array
  }
}

Runtime: O(1)

Public void grow(){
  int[]B = new int[A.length*2]
  System.arraycopy(A,B)
  A=B
}

where N = current array size
and M = number of adds

Runtime: O(N)

#### Side note:
In Java, the computer keeps track of the length of each array starting when you
initialize it. In C, they don't keep track of array length - the computer doesn't
see the end of the array.

###Delete

It's expensive to decrease the size when you're at half full in an array list.
(an O(N) operation).
