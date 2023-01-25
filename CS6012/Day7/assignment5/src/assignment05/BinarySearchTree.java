package assignment05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable <? super T >> implements SortedSet<T> {

    private Node<T> root;// setup the member variable
    private int size;

    private static class Node<T extends Comparable<? super T>>{//define node of the BST， 所有的元素都是comparable的 ，所以在后面是可以使用compareto
        T value;//节点本身的value
        Node<T> left,right; // 节点分裂的左右节点

        public Node(T value){//instance variable of Node class
            this.value = value;
            this.left = this.right = null;// 节点的左右节点设置为空
        }
    }
    BinarySearchTree(){  // constructor for initialise the root to null
        this.root = null;
        this.size = 0;
    }
    @Override
    public boolean add(T value)throws NullPointerException {
        if(value == null) throw new NullPointerException();// check for root is not null or not
        int originalSize = this.size;//存储初始的size
        if(contains(value)){// if the value already there, return fasle.
            return false;
        }else {
            this.root = addRecursive(root, value);// 递归函数， 自己call 自己，现在这个元素都在这个递归里面去运行,是从root开始
            return this.size > originalSize;
        }
    }

    private Node<T> addRecursive(Node<T> node,T value){// 是在用节点和要加入的元素比较
        if (node == null) {
            node = new Node<>(value); // 如果这个Node 是空的话，元素就是在这个节点的位置，并且BST 的size 增加。
            this.size++;
        }else if (value.compareTo(node.value)<0){
            node.left = addRecursive(node.left,value);// 如果node比元素小，元素放在左边
        }else if( value.compareTo(node.value)>0){
            node.right = addRecursive(node.right,value);//如果node 比元素大， 元素放在右边
        }
        return node;// 最后在放在哪个空的node里面

    }

    @Override
    public boolean addAll(Collection<? extends T> items) throws NullPointerException{
        Object[] itemList = items.toArray();// 做成一个object ，将加入的element 都存在这个array里
        boolean itemAdded = false;// 检查element 是否加进去了
        for (int y = 0; y < itemList.length; y++){
            if (itemList[y] == null) throw new NullPointerException();// 如果是在这个itemlist 是空的，这个就不可以被添加
            }
        for (int x = 0; x < itemList.length;x++){
            if (add((T) itemList[x])){
                itemAdded = true;
            }
        }
        return itemAdded;
    }

    @Override
    public void clear() {// reset
        this.root = null;
        this.size = 0;

    }

    @Override
    public boolean contains(T item) throws NullPointerException {
        if (item == null) throw new NullPointerException();// check for item is not null or not
        return containsRecursive( this.root,item);//need a recusive method to go through all the node in tree to check  either the tree has containt the
        // the elment
    }

    private boolean containsRecursive(Node<T> node,T value){// same recusive method with the add method
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
    public T first() throws NoSuchElementException {// find the most left leave , the will the smallest and first element
        if (this.root == null) throw  new NoSuchElementException();
        Node<T> node = this.root;// start with at root
        while (node.left!= null)node=node.left;// if the node is not nothing going to next left node

        return node.value;
    }

    @Override
    public boolean isEmpty() { // if size = 0, this the tree is empty.
        return this.size == 0;
    }

    @Override
    public T last() throws NoSuchElementException {// find the most right leave , the will the smallest and first element
        if (this.root == null) throw new NoSuchElementException();
        Node<T> node = this.root;
        while  ( node.right != null) node = node.right;// if the node is not nothing going to next right node



        return node.value;
    }

    @Override
    public boolean remove(T item) throws NullPointerException {
        if ( item == null)throw  new NullPointerException();
        if ( this.size == 1 ){// if BST only have root. rest BST.
            clear();}
        if (!contains(item)) return false;// if the item was not in the BST. return false
        Node<T> parent, removed;
        if ( this.root.value.equals(item)){
            parent = this.root;
            removed = this.root;
        }else {
            parent = findParent(this.root,item);// find out the parent node.
            if(parent.left.value.equals(item)){//if the left child node value = item value
                removed = parent.left;// remove the node
            }else{// otherwide to right node
                removed = parent.right;
            }
        }

        if(removed.left == null&& removed.right == null){ // at the bottom of the tree.
            return removeleaf(parent,item);
        }else if (removed.left != null && removed.right != null){// at node going to remove has two chidren
            return removeDoubleChildren( parent,item);
        }else {//at the node only has single child
            return removedSingleChid(parent, item);
        }
        }

        private  boolean removeleaf(Node<T> parent,T item){
        if (parent.left.value.equals(item)){// this node = item. return is node as null
            parent.left = null;
        }else{// same for other side
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
//    private Node<T> findRightBranchMin (Node<T> node,T value){// 是在用节点和要加入的元素比较
//        Node<T> rightNode = this.getright(); // right node
//        while (rightNode.left!= null) rightNode = rightNode.left;
//        return rightNode;
//        if (node == null) {
//            node = new Node<>(value); // 如果这个Node 是空的话，元素就是在这个节点的位置，并且BST 的size 增加。
////            this.size++;
//        }else if (value.compareTo(node.value)<0){
//            node.left = addRecursive(node.left,value);// 如果node比元素小，元素放在左边
//        }
//        return node;// 最后在放在哪个空的node里面

//    }

       private Node<T> findParent(Node<T> node, T item){
        if (node.left.value.equals(item)|| node.right.value.equals(item)){// if the removed node = either child node value
            return node;// return node is the parent node.
        }else if( item.compareTo(node.value)<0){// if the itme is less than the parent node, value to down to campare with left child node
            node = node.left;
            return findParent(node,item);
        }else {// going to other side.
            node = node.right;
            return  findParent(node,item);
        }
       }

        private boolean removedSingleChid(Node<T> parent,T item){
        if (parent.left.value.equals(item)){//if the left node equal to the item , parent's left node will replace by the parent.right node
            if(parent.left.left == null){
                parent.left= parent.left.right;
            }else {
                parent.left = parent.left.left;
            }
        }else{//other way
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
    public boolean removeAll(Collection <? extends T> items) throws NullPointerException {// same with addall
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

