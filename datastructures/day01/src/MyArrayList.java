/*
Data Structures and Algorithms
Spring 2018
Gracey Wilson

ArrayLists Practice
*/

public class MyArrayList {
    private Cow[] elems;
    private int size;

    // TODO: Runtime: O(?)
    public MyArrayList() {
        this(10);
        size = 0;
    }

    // TODO: Runtime: O(?)
    public MyArrayList(int capacity) {
        elems = new Cow[capacity];
        size = 0;
    }

    // TODO: Runtime: O(?)
    public void add(Cow c) {
        elems[size] = c; //add new cow "c" at index "size" (last index). Don't have to specify type again (Cow c)
        size++;   //make the size one index bigger so the arraylist isn't full

        if (size == elems.length){
            Cow[] tempElems = new Cow[size*2];
            System.arraycopy(elems,0,tempElems,0,size);
            elems = tempElems;
        }
    }

    // TODO: Runtime: O(?)
    public int size() {
        return size;  //works because size is initialized at the top
    }

    // TODO: Runtime: O(?)
    public Cow get(int index) {
        if (size < index) {
            throw new IndexOutOfBoundsException();
        }
        return elems[index];
    }

    // TODO: Runtime: O(?)
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

    // TODO: Runtime: O(?)
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