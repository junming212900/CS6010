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
        assertTrue(integerBinarySeachThree.contains(10));
        assertFalse(stringBinarySearchTree.contains("a"));
    stringBinarySearchTree.add("a");
    stringBinarySearchTree.add("b");
    stringBinarySearchTree.add("c");
    stringBinarySearchTree.add("d");
    stringBinarySearchTree.add("e");
    stringBinarySearchTree.add("f");
    stringBinarySearchTree.add("g");
        assertTrue(stringBinarySearchTree.contains("a"));
        assertTrue(stringBinarySearchTree.contains("b"));
        stringBinarySearchTree.add("Argentina World Cup Champions 2022");
        assertTrue(stringBinarySearchTree.contains("Argentina World Cup Champions 2022"));
        assertFalse(stringBinarySearchTree.contains("Messi world cup winner 2022"));
}
@Test
    void containsall(){

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
    integerArrayList.add(2);
    assertTrue(integerBinarySeachThree.containsAll(integerArrayList));
    integerArrayList.add(3);
    assertTrue(integerBinarySeachThree.containsAll(integerArrayList));
    integerArrayList.add(65);
    assertFalse(integerBinarySeachThree.containsAll(integerArrayList));
}
@Test
    void first(){
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
    assertEquals(integerBinarySeachThree.first(),1);
}
@Test
    void isEmpty(){
    stringBinarySearchTree.add("a");
    stringBinarySearchTree.add("b");
    stringBinarySearchTree.add("c");
    stringBinarySearchTree.add("d");
    stringBinarySearchTree.add("e");
    stringBinarySearchTree.add("f");
    stringBinarySearchTree.add("g");
        stringBinarySearchTree.add("k");
        assertFalse(stringBinarySearchTree.isEmpty());
        stringBinarySearchTree.clear();
    assertTrue(stringBinarySearchTree.isEmpty());
}
@Test
    void last(){
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
    assertEquals(integerBinarySeachThree.last(),10);
}
@Test
    void remove(){
    stringBinarySearchTree.add("a");
    stringBinarySearchTree.add("b");
    stringBinarySearchTree.add("c");
    stringBinarySearchTree.add("d");
    stringBinarySearchTree.add("e");
    stringBinarySearchTree.add("f");
    stringBinarySearchTree.add("g");
    assertEquals(stringBinarySearchTree.size(),7);
    stringBinarySearchTree.remove("a");
    assertEquals(stringBinarySearchTree.size(),6);
    integerBinarySeachThree.add(15);
    integerBinarySeachThree.add(7);
    integerBinarySeachThree.add(1);
    integerBinarySeachThree.add(8);
    integerBinarySeachThree.add(22);
    integerBinarySeachThree.add(19);
    integerBinarySeachThree.add(30);
    /*                  6

     */

    integerBinarySeachThree.remove(22);
    assertEquals(integerBinarySeachThree.getvalue(integerBinarySeachThree.getright(integerBinarySeachThree.getRoot())),30);
    integerBinarySeachThree.remove(7);
    assertEquals(integerBinarySeachThree.getvalue(integerBinarySeachThree.getleft(integerBinarySeachThree.getRoot())),8);
    integerBinarySeachThree.clear();
    assertTrue(integerBinarySeachThree.isEmpty());

    integerBinarySeachThree.add(15);
    integerBinarySeachThree.add(7);
    integerBinarySeachThree.add(1);
    integerBinarySeachThree.add(8);
    integerBinarySeachThree.add(22);
    integerBinarySeachThree.add(19);
    integerBinarySeachThree.add(30);

    integerBinarySeachThree.remove(15);
    assertEquals(integerBinarySeachThree.getvalue(integerBinarySeachThree.getRoot()),19);
}
@Test
    void removall(){
    integerBinarySeachThree.add(15);
    integerBinarySeachThree.add(7);
    integerBinarySeachThree.add(1);
    integerBinarySeachThree.add(8);
    integerBinarySeachThree.add(22);
    integerBinarySeachThree.add(19);
    integerBinarySeachThree.add(30);
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

