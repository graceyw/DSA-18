/*
Data Structures and Algorithms
Spring 2018
Gracey Wilson

Day 01 ArrayLists
*/

public class MyArrayList {
    private Cow[] elems;
    private int size;

    // Runtime: O(1)
    public MyArrayList() {
        this(10);
        size = 0;
    }

    // Runtime: O(1)
    public MyArrayList(int capacity) {
        elems = new Cow[capacity];
        size = 0;
    }

    // Runtime: O(1) (on average, because it's not always going to have to resize which is O(N))
    public void add(Cow c) {
        elems[size] = c; //add new cow "c" at index "size" (last index). Don't have to specify type again (Cow c)
        size++;   //make the size one index bigger so the arraylist isn't full

        if (size == elems.length){
            Cow[] tempElems = new Cow[size*2];
            System.arraycopy(elems,0,tempElems,0,size);
            elems = tempElems;
        }
    }

    // Runtime: O(1)
    public int size() {
        return size;  //works because size is initialized at the top
    }

    // Runtime: O(1)
    public Cow get(int index) {
        if (size < index) {
            throw new IndexOutOfBoundsException();
        }
        return elems[index];
    }

    // Runtime: O(N)
    public Cow remove(int index) {
        if (size <= index) {
            throw new IndexOutOfBoundsException();
        }
        Cow judy = elems[index]; //save the cow to "judy"
        System.arraycopy(elems,index+1,elems,index,size-index); //(source_arr,sourcePos,dest_arr,destPos,length of stuff to copy)

        if (size/elems.length <= 1/4 && size < 10){
            Cow[] tempElems = new Cow[size/2];
            System.arraycopy(elems,0,tempElems,0,size/2);
            elems = tempElems;
        }
        size--;
        return judy; //return the saved Cow named judy
    }

    // Runtime: O(N)
    public void add(int index, Cow c) {
        if (size < index){
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(elems,index,elems,index+1,size-index); //(source_arr,sourcePos,dest_arr,destPos,length of stuff to copy)
        elems[index] = c;

        if (size == elems.length){
            Cow[] tempElems = new Cow[size*2];
            System.arraycopy(elems,0,tempElems,0,size);
            elems = tempElems;
        }
        size++;
    }
}
