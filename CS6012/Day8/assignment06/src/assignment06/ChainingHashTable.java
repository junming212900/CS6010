package assignment06;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Iterator;

public class ChainingHashTable implements Set<String>{

    private LinkedList<String>[] storage;
    private HashFunctor functor;//to calculate te hash value
    private int capacity;
    private int size;
    private int collisions;
    @SuppressWarnings("unchecked")

    public ChainingHashTable(int capacity,HashFunctor functor){
        this.storage = (LinkedList<String>[]) new LinkedList[capacity];
        this.functor = functor;
        this.capacity = capacity;
        this.size = 0;
        this.collisions = 0;
    }
    @Override
    public boolean add(String item) {
        int hashIndex = functor.hash(item)%capacity;// firgue out the location of each element has colision
        if(storage[hashIndex] == null){// create a new Linkedlist and add the item into the linked list
            LinkedList<String> list = new LinkedList<>();
            list.add(item);
            storage[hashIndex] = list;
            size++;
            return true;

        }else if(storage[hashIndex].contains(item)){// linkedlist item already exist
            return false;
        }else{// add item into exist linked list
            storage[hashIndex].add(item);
            size++;
            collisions++;
            return true;
        }

    }

    @Override
    public boolean addAll(Collection<? extends String> items) {//using iterator to add all items from list to other array
        Iterator<? extends String> iterator = items.iterator();
        int OrignalSize = size;
        while( iterator.hasNext())add(iterator.next());
        return size != OrignalSize;
    }

    @Override
    public void clear() {
        storage = (LinkedList<String>[]) new LinkedList[capacity];
        size = 0;
    }

    @Override
    public boolean contains(String item) {// check the item either in the array
        int hashIndex = functor.hash(item)% capacity;
        return storage[hashIndex] != null&& storage[hashIndex].contains(item);

    }

    @Override
    public boolean containsAll(Collection<? extends String> items) {// check each item inthe list or array
        for(String item: items) if (!contains(item)) return false;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(String item) {// find out the location
        int hashIndex = functor.hash(item)%capacity;
        if(storage[hashIndex]== null || !storage[hashIndex].contains(item)){
            return false;// if item is not in the list ,return false
        }else{// if the item is in th array
            storage[hashIndex].remove(item);// remove the item
            size--;
//
            return true;
        }
    }


    @Override
    public boolean removeAll(Collection<? extends String> items) {// create iterator to remove one by one item in list from array
        Iterator< ? extends String > iterator = items.iterator();
        int OriginalSize = size;
        while ( iterator.hasNext()) remove(iterator.next());
        return size != OriginalSize;
    }

    @Override
    public int size() {
        return this.size;
    }
    public int getCollisions(){return this.collisions;}
}
