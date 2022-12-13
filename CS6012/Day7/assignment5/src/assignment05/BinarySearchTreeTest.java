package assignment05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    BinarySearchTree<String> stringBinarySearchTree;
    BinarySearchTree<Integer> integerBinarySeachThree;
    ArrayList<String> stringArrayList;
    ArrayList<Integer> integerArrayList;

    @BeforeEach
    void setUp(){
        stringBinarySearchTree = new BinarySearchTree<>();
        integerArrayList = new ArrayList<>();
        integerBinarySeachThree =new BinarySearchTree<>();
        stringArrayList = new ArrayList<>();

    }
    @AfterEach
    void tearDown(){
        stringBinarySearchTree =null;
        integerBinarySeachThree =null;
        stringArrayList = null;
        integerArrayList =null;
    }
    @Test
    void add(){
        assertEquals(stringBinarySearchTree.size(),0);
        assertThrows(NullPointerException.class,()->{stringBinarySearchTree.add(null);});
        stringBinarySearchTree.add("a");
        stringBinarySearchTree.add("b");
        stringBinarySearchTree.add("c");
        stringBinarySearchTree.add("d");
        stringBinarySearchTree.add("e");
        stringBinarySearchTree.add("f");
        stringBinarySearchTree.add("g");
        assertEquals(stringBinarySearchTree.size(),7);
        stringBinarySearchTree.add("a");
        assertEquals(stringBinarySearchTree.size(),7);
        integerBinarySeachThree.add(1);
        integerBinarySeachThree.add(2);
        integerBinarySeachThree.add(3);
        integerBinarySeachThree.add(4);
        integerBinarySeachThree.add(5);
        integerBinarySeachThree.add(6);
        integerBinarySeachThree.add(7);
        integerBinarySeachThree.add(8);
        integerBinarySeachThree.add(9);
        integerBinarySeachThree.add(10);
        assertEquals(integerBinarySeachThree.size(),10);
        integerBinarySeachThree.add(10);
        assertEquals(integerBinarySeachThree.size(),10);
    }
    @Test
    void addAll(){
        stringArrayList.add("ab");
        stringArrayList.add("ac");
        stringArrayList.add("ad");
        stringArrayList.add("af");
        stringArrayList.add("ah");
        stringArrayList.add("aq");
        stringArrayList.add("aj");
        stringBinarySearchTree.addAll(stringArrayList);
        assertEquals(stringBinarySearchTree.size(),7);
        stringArrayList.add("Argentina World Cup Champions 2022");
        stringArrayList.add("Messi world cup winner 2022");
        stringBinarySearchTree.addAll(stringArrayList);
        assertEquals(stringBinarySearchTree.size(),9);
        integerArrayList.add(1);
        integerArrayList.add(11);
        integerArrayList.add(12);
        integerArrayList.add(13);
        integerArrayList.add(14);
        integerArrayList.add(115);
        integerArrayList.add(114);
        integerArrayList.add(16);
        integerBinarySeachThree.addAll(integerArrayList);
        assertEquals(integerBinarySeachThree.size(),8);




    }
    @Test
    void clear(){
        stringBinarySearchTree.add("a");
        stringBinarySearchTree.add("b");
        stringBinarySearchTree.add("c");
        stringBinarySearchTree.add("d");
        stringBinarySearchTree.add("e");
        stringBinarySearchTree.add("f");
        stringBinarySearchTree.add("g");
        stringBinarySearchTree.clear();
        assertEquals(stringBinarySearchTree.size(),0);
assertThrows(NoSuchElementException.class,()->{stringBinarySearchTree.first();});


    }
@Test
    void contains(){
        assertFalse(integerBinarySeachThree.contains(1));
        integerBinarySeachThree.add(1);
        assertTrue(integerBinarySeachThree.contains(1));
        assertFalse(stringBinarySearchTree.contains("a"));
        stringBinarySearchTree.add("a");
        assertTrue(stringBinarySearchTree.contains("a"));
        stringBinarySearchTree.add("b");
        assertTrue(stringBinarySearchTree.contains("b"));
        stringBinarySearchTree.add("ab");
        assertTrue(stringBinarySearchTree.contains("ab"));
        assertFalse(stringBinarySearchTree.contains("c"));
}
@Test
    void containsall(){

    integerBinarySeachThree.add(2);
    integerBinarySeachThree.add(1);
    integerBinarySeachThree.add(3);
    integerArrayList.add(2);
    assertTrue(integerBinarySeachThree.containsAll(integerArrayList));
    integerArrayList.add(3);
    assertTrue(integerBinarySeachThree.containsAll(integerArrayList));
    integerArrayList.add(4);
    assertFalse(integerBinarySeachThree.containsAll(integerArrayList));
}
@Test
    void first(){
    integerBinarySeachThree.add(2);
    integerBinarySeachThree.add(1);
    integerBinarySeachThree.add(3);
    assertEquals(integerBinarySeachThree.first(),1);
}
@Test
    void isEmpty(){
        assertTrue(stringBinarySearchTree.isEmpty());
        stringBinarySearchTree.add("k");
        assertFalse(stringBinarySearchTree.isEmpty());
}
@Test
    void last(){
    integerBinarySeachThree.add(2);
    integerBinarySeachThree.add(1);
    integerBinarySeachThree.add(3);
    assertEquals(integerBinarySeachThree.last(),3);
}
@Test
    void remove(){
    stringBinarySearchTree.add("a");
    assertEquals(stringBinarySearchTree.size(),1);
    stringBinarySearchTree.remove("a");
    assertEquals(stringBinarySearchTree.size(),0);
    integerBinarySeachThree.add(4);
    integerBinarySeachThree.add(2);
    integerBinarySeachThree.add(1);
    integerBinarySeachThree.add(3);
    integerBinarySeachThree.add(6);
    integerBinarySeachThree.add(5);
    integerBinarySeachThree.add(7);
    /*                  6

     */

    integerBinarySeachThree.remove(6);
    assertEquals(integerBinarySeachThree.getvalue(integerBinarySeachThree.getright(integerBinarySeachThree.getRoot())),7);
    integerBinarySeachThree.remove(2);
    assertEquals(integerBinarySeachThree.getvalue(integerBinarySeachThree.getleft(integerBinarySeachThree.getRoot())),3);
    integerBinarySeachThree.clear();
    assertTrue(integerBinarySeachThree.isEmpty());

    integerBinarySeachThree.add(4);
    integerBinarySeachThree.add(2);
    integerBinarySeachThree.add(1);
    integerBinarySeachThree.add(3);
    integerBinarySeachThree.add(6);
    integerBinarySeachThree.add(5);
    integerBinarySeachThree.add(7);

    integerBinarySeachThree.remove(4);
    assertEquals(integerBinarySeachThree.getvalue(integerBinarySeachThree.getRoot()),5);
}
@Test
    void removall(){
    integerBinarySeachThree.add(4);
    integerBinarySeachThree.add(2);
    integerBinarySeachThree.add(1);
    integerBinarySeachThree.add(3);
    integerBinarySeachThree.add(6);
    integerBinarySeachThree.add(5);
    integerBinarySeachThree.add(7);
    assertFalse(integerBinarySeachThree.removeAll(integerArrayList));
    integerArrayList.add(1);
    assertTrue(integerBinarySeachThree.removeAll(integerArrayList));
    assertEquals(integerBinarySeachThree.size(),6);
    integerArrayList.add(7);
    assertTrue(integerBinarySeachThree.removeAll(integerArrayList));
    assertEquals(integerBinarySeachThree.size(),5);
    assertFalse(integerBinarySeachThree.contains(7));
}


}

