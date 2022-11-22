package assignment03;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchSet<E> implements SortedSet, Iterator {
    private E[] data;
    private int size;
    private int capactiy = 10;
    private Comparator<? super E> comparator = null;// <? super E > 表示包括在E在内的任何E的父类 。 < ? extend E > 表示包括在E在内的任何E的子类 // 在基础变量 写出已知的comparator

    public BinarySearchSet() {
        this.data = (E[]) new Object[capactiy];//data is arraylist capacity is float
        this.size = 0;// size start 0.
    }

    public BinarySearchSet(Comparator<? super E> comparator) {
        this.data = (E[]) new Object[capactiy];
        this.size = 0;
        this.comparator = comparator;
    }

    @Override
    public Comparator comparator() {
        return this.comparator;
    }

    @Override
    public Object first() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();
        return 0;
    }

    @Override
    public Object last() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();
        return 0;
    }

    @Override
    public boolean add(Object element) {
        if (element == null || this.contains(element))
            return false;// if the element not exsit and or already in the set. return false
        if (size == capactiy) grow();// size and capacity need grow to make in enough room for new element
        data[size++] = (E) element;// adding new element.
        bubbleSort();//sort the data array
        return true;
    }


    @Override
    public boolean addAll(Collection elements) {
        Iterator< ? extends E> iterator = elements.iterator();
        int OGsize = this.size; // mark origanal size.
        while(iterator.hasNext())add(iterator.next()); // adding all element into data
        return this.size != OGsize;// compare orginal size with size after add elements
    }

    @Override
    public void clear() {// clearup all element from data. turn capacity & size to 0 reinitalize.
        capactiy = 0;
        data = (E[]) new Object[capactiy];
        size = 0 ;

    }

    @Override
    public boolean contains(Object element) {
        return binaryrsearch((E) element) != -1;
    }

    @Override
    public boolean containsAll(Collection elements) {
        for (Object object: elements) {
            if (!contains(object))

                return false;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator iterator() {
        SetIterator setIterator = new SetIterator();
        return setIterator;
    }

    @Override
    public boolean remove(Object element) {
        int i = binaryrsearch((E) element);
        if (i == -1) {
            return false;
        } else {
            capactiy--;
            E[] newdata = (E[]) new Object[capactiy];
            for (int j = 0; j < i; j++) {
                newdata[j] = data[j];
            }
            for (int k = i + 1; k < data.length; k++) {
                newdata[k] = data[k];
            }
            data = newdata;
            size--;
            return true;
        }

    }

    @Override
    public boolean removeAll(Collection elements) {
        Iterator<E> iterator = elements.iterator();
        int OGsize = size;
        while(iterator.hasNext()) remove(iterator.next());
        return size!= OGsize;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return  data;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    private void grow() {
        capactiy += 10;// capactiy will increase
        E[] newdata = (E[]) new Object[capactiy]; //create a new array
        for (int i = 0; i < data.length; i++) {
            newdata[i] = data[i];// put old elements to newdata array
        }
        data = newdata; // let new array replace old array.
    }

    private void bubbleSort() {
        Comparator<? super E> comparator = this.comparator;
        if (data == null || isEmpty()) return;
        if (comparator == null) {// set up as natural ordering
            int i, j;
            for (i = 0; i < data.length - 1; i++) {// Last i elements are already in place
                for (j = 0; j < data.length - i - 1; j++) {
                    Comparable<E> Element1 = (Comparable<E>) data[j];
                    Comparable<E> Element2 = (Comparable<E>) data[j + 1];

                    if (Element1.compareTo((E) Element2) > 0) {
                        Comparable<E> temp = (Comparable<E>) data[j];
                        data[j] = (E) Element2;
                        data[j + 1] = (E) temp;

                    }
                }
            }

        } else {
            int i, j;
            for (i = 0; i < data.length - 1; i++) {// Last i elements are already in place
                for (j = 0; j < data.length - i - 1; j++) {
                    if (comparator.compare(data[j], data[j + 1]) > 0) {
                        E temp = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = temp;

                    }
                }

            }
        }
    }
    public int binaryrsearch(E element){
        int left = 0, right = data.length-1, i=0;
        if (size == 0 ) return -1;
        if ( comparator== null ){
            while(left<=right){
                i = (left+right) / 2;
                Comparable<E> Element1 = (Comparable<E>) data[i];
                if (element == data[i]){return i;}
                else if (Element1.compareTo(element)>0){left = i+1;}
                else {right = i -1;}
            }
        }

        while(left<=right){
             i = (left+right) / 2;
            if(element == data[i]) {return i;}
            else if (comparator.compare(data[i],element) >0) { left = i+1;}
            else {right = i -1;}
        }

        return -1;
    }
    private class SetIterator implements Iterator<E> {
        int Position;
        public SetIterator(){Position=0;}

        @Override
        public boolean hasNext() {
            return this.Position< data.length;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (this.hasNext()){
                return data[this.Position++];
            }
            else {
                throw new NoSuchElementException();
            }
        }

        }
    }



