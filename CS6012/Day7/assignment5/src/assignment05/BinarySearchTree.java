package assignment05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable <? super T >> implements SortedSet<T> {

    private Node<T> root;
    private int size;

    private static class Node<T extends Comparable<? super T>>{
        T value;
        Node<T> left,right;

        public Node(T value){
            this.value = value;
            this.left = this.right = null;
        }
    }
    BinarySearchTree(){
        this.root = null;
        this.size = 0;
    }
    @Override
    public boolean add(T value)throws NullPointerException {
        if(value == null) throw new NullPointerException();
        int originalSize = this.size;
        if(contains(value)){
            return false;
        }else {
            this.root = addRecursive(root, value);
            return this.size > originalSize;
        }
    }

    private Node<T> addRecursive(Node<T> node,T value){
        if (node == null) {
            node = new Node<>(value);
            this.size++;
        }else if (value.compareTo(node.value)<0){
            node.left = addRecursive(node.left,value);
        }else if( value.compareTo(node.value)>0){
            node.right = addRecursive(node.right,value);
        }
        return node;


    }

    @Override
    public boolean addAll(Collection<? extends T> items) throws NullPointerException{
        Object[] itemList = items.toArray();
        boolean itemAdded = false;
        for (int y = 0; y < itemList.length; y++){
            if (itemList[y] == null) throw new NullPointerException();
            }
        for (int x = 0; x < itemList.length;x++){
            if (add((T) itemList[x])){
                itemAdded = true;
            }
        }
        return itemAdded;
    }

    @Override
    public void clear() {
        this.root = null;
        this.size = 0;

    }

    @Override
    public boolean contains(T item) throws NullPointerException {
        if (item == null) throw new NullPointerException();
        return containsRecursive( this.root,item);
    }

    private boolean containsRecursive(Node<T> node,T value){
        if ( node == null){
            return  false;
        }else if (node.value.compareTo(value)==0){
            return true;
        }else if( value.compareTo(node.value)<0){
            return  containsRecursive(node.left,value);
        }else if (value.compareTo(node.value)>0){
            return containsRecursive(node.right,value);
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<? extends T> items) {
        for( T item: items){
            if (! contains(item)) return false;
        }
        return true;
    }

    @Override
    public T first() throws NoSuchElementException {
        if (this.root == null) throw  new NoSuchElementException();
        Node<T> node = this.root;
        while (node.left!= null)node=node.left;

        return node.value;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public T last() throws NoSuchElementException {
        if (this.root == null) throw new NoSuchElementException();
        Node<T> node = this.root;
        while  ( node.right != null) node = node.right;



        return node.value;
    }

    @Override
    public boolean remove(T item) throws NullPointerException {
        if ( this.size == 1 ){
            this.root = null;
            this.size =0;
        }
        if ( item == null)throw  new NullPointerException();
        if (!contains(item)|| this.size == 0) return false;

        Node<T> parent, removed;
        if ( this.root.value.equals(item)){
            parent = this.root;
            removed = this.root;
        }else {
            parent = findParent(this.root,item);
            if(parent.left.value.equals(item)){
                removed = parent.left;
            }else{
                removed = parent.right;
            }
        }

        if(removed.left == null&& removed.right == null){
            return removeleaf(parent,item);
        }else if (removed.left != null && removed.right != null){
            return removeDoubleChildren( parent,item);
        }else {
            return removedSingleChid(parent, item);
        }
        }

        private  boolean removeleaf(Node<T> parent,T item){
        if (parent.left.value.equals(item)){
            parent.left = null;
        }else{
            parent.right = null;
        }
        this.size--;
        return true;
        }

        private boolean removeDoubleChildren(Node<T> parent,T item) {
            if (this.root.value.equals(item)) {
                parent = this.root;
            } else if (parent.left.value.equals(item)) {
                parent = parent.left;
            } else {
                parent = parent.right;
            }
            Node<T> successor = parent.right;
            Node<T> successorParent = parent;
            int count = 0;
            while (successor.left != null) {
                if (count == 0) {
                    successorParent = successorParent.right;
                } else {
                    successorParent = successorParent.left;
                }
                successor = successorParent.left;
                count++;
            }
            parent.value = successor.value;
                if (successor.right == null) {
                    return removeleaf(successorParent, successor.value);
                } else {
                    return removedSingleChid(successorParent, successor.value);
                }
            }

       private Node<T> findParent(Node<T> node, T item){
        if (node.left.value.equals(item)|| node.right.value.equals(item)){
            return node;
        }else if( item.compareTo(node.value)<0){
            node = node.left;
            return findParent(node,item);
        }else {
            node = node.right;
            return  findParent(node,item);
        }
       }

        private boolean removedSingleChid(Node<T> parent,T item){
        if (parent.left.value.equals(item)){
            if(parent.left.left == null){
                parent.left= parent.left.right;
            }else {
                parent.left = parent.left.left;
            }
        }else{
            if(parent.right.left == null){
                parent.right = parent.right.right;
            }else{
                parent.right = parent.right.left;
            }
        }
        this.size--;
        return true;
        }

    @Override
    public boolean removeAll(Collection <? extends T> items) throws NullPointerException {
        Object[] itemArray = items.toArray();
        boolean itemRemoved = false;
        for (Object item : itemArray){
            if(item == null) throw new NullPointerException();
        }
        for(Object item : itemArray){
            if (remove((T)item)){
                itemRemoved = true;
            }
        }
        return itemRemoved;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ArrayList<T> toArrayList() {
        ArrayList<T> arrayList = new ArrayList<>();
        inOrderTraversal(this.root,arrayList);
        return arrayList;
    }
    public void inOrderTraversal(Node<T> node, ArrayList<T> list){
        if(node != null){
            inOrderTraversal(node.left,list);
            list.add(node.value);
            inOrderTraversal(node.right,list);
        }
    }
    public  Node<T> getRoot(){return this.root;}
    public  Node<T> getleft(Node<T> node){return node.left;}
    public  Node<T> getright(Node<T> node){return node.right;}
    public T getvalue(Node<T> node){return node.value;}
}

