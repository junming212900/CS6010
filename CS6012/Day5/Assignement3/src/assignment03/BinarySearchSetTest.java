package assignment03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchSetTest {
    BinarySearchSet<String> stringBinarySearchSet;
    BinarySearchSet<Integer> integerBinarySearchSet;
    BinarySearchSet<Integer> comparatorIntegerSet;

    ArrayList<Integer> integerArrayList;

    ArrayList<Integer> integerArrayList1;

    ArrayList<String> stringArrayList;

    @BeforeEach
    void setup() {
        stringBinarySearchSet = new BinarySearchSet<>();
        integerBinarySearchSet = new BinarySearchSet<>();
        comparatorIntegerSet = new BinarySearchSet<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        integerArrayList = new ArrayList<>();
        integerArrayList1 = new ArrayList<>();
        stringArrayList = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        stringBinarySearchSet = null;
        integerBinarySearchSet = null;
        comparatorIntegerSet = null;
        integerArrayList = null;
        integerArrayList1 = null;
        stringArrayList = null;
    }

    @Test
    void first() {
        integerBinarySearchSet.add(6);
        integerBinarySearchSet.add(5);
        integerBinarySearchSet.add(4);
        integerBinarySearchSet.add(3);
        integerBinarySearchSet.add(2);
        integerBinarySearchSet.add(1);

        assertEquals(integerBinarySearchSet.first(), 1);
    }

    @Test
    void last() {
        integerBinarySearchSet.add(6);
        integerBinarySearchSet.add(5);
        integerBinarySearchSet.add(4);
        integerBinarySearchSet.add(3);
        integerBinarySearchSet.add(2);
        integerBinarySearchSet.add(1);
        assertEquals(integerBinarySearchSet.last(), 6);
    }

    @Test
    void add() {
        stringBinarySearchSet.add("one");
        stringBinarySearchSet.add("two");
        assertEquals(stringBinarySearchSet.getValue(0), "one");
        assertEquals(stringBinarySearchSet.getValue(1), "two");

        integerBinarySearchSet.add(6);
        assertEquals(integerBinarySearchSet.getValue(0), 6);


        integerBinarySearchSet.add(9);
        integerBinarySearchSet.add(2);
        integerBinarySearchSet.add(8);
        integerBinarySearchSet.add(1);
        assertEquals(integerBinarySearchSet.getValue(3), 8);

        comparatorIntegerSet.add(6);
        comparatorIntegerSet.add(1);
        comparatorIntegerSet.add(7);
        comparatorIntegerSet.add(10);
        comparatorIntegerSet.add(15);
        comparatorIntegerSet.add(14);
        comparatorIntegerSet.add(20);
        comparatorIntegerSet.add(9);
        assertEquals(comparatorIntegerSet.getValue(0), 20);
        assertEquals(comparatorIntegerSet.getValue(3), 10);
    }

    @Test
    void addALL() {
        integerArrayList.add(8);
        integerArrayList.add(12);
        integerArrayList.add(14);
        integerArrayList.add(20);
        integerArrayList.add(1);
        integerArrayList.add(25);
        integerArrayList.add(9);
        integerArrayList.add(5);
        integerArrayList.add(7);
        integerArrayList.add(4);
        integerArrayList.add(13);
        integerBinarySearchSet.addAll(integerArrayList);
        assertEquals(integerBinarySearchSet.size(), 11);
        assertEquals(integerBinarySearchSet.first(), 1);
        assertEquals(integerBinarySearchSet.last(), 25);

        integerArrayList1.add(25);
        integerArrayList1.add(7);
        assertFalse(integerBinarySearchSet.addAll(integerArrayList1));

        integerArrayList1.add(6);
        assertTrue(integerBinarySearchSet.addAll(integerArrayList1));
        integerBinarySearchSet.addAll(integerArrayList1);
        assertEquals(integerBinarySearchSet.size(), 12);
        assertEquals(integerBinarySearchSet.getValue(1), 4);
    }

    @Test
    void clear() {
        stringBinarySearchSet.add("one");
        stringBinarySearchSet.add("two");
        stringBinarySearchSet.add("three");
        assertFalse(stringBinarySearchSet.isEmpty());
        stringBinarySearchSet.clear();
        assertTrue(stringBinarySearchSet.isEmpty());

    }
@Test
    void contains() {
        assertFalse(stringBinarySearchSet.contains(225));
        stringBinarySearchSet.add(1);
        stringBinarySearchSet.add(6);
        stringBinarySearchSet.add(3);
        stringBinarySearchSet.add(4);
        stringBinarySearchSet.add(5);
        assertFalse(stringBinarySearchSet.contains(2));
        assertTrue(stringBinarySearchSet.contains(1));
    }

    @Test
    void containsall() {
        stringBinarySearchSet.add("1");
        stringBinarySearchSet.add("2");
        stringBinarySearchSet.add("3");
        stringArrayList.add("1");
        stringArrayList.add("3");
        assertTrue(stringBinarySearchSet.containsAll(stringArrayList));
        stringArrayList.add("4");
        assertFalse(stringBinarySearchSet.containsAll(stringArrayList));
    }

    @Test
    void isEmpty() {

        stringBinarySearchSet.add("hello");
        assertFalse(stringBinarySearchSet.isEmpty());
        stringBinarySearchSet.clear();
        assertTrue(stringBinarySearchSet.isEmpty());
    }

    @Test
    void remove() {
        stringBinarySearchSet.add("1");
        stringBinarySearchSet.add("2");
        stringBinarySearchSet.add("3");
        stringBinarySearchSet.add("4");
        stringBinarySearchSet.add("5");
        stringBinarySearchSet.add("6");
        stringBinarySearchSet.remove("5");
        assertEquals(stringBinarySearchSet.size(), 5);
        assertFalse(stringBinarySearchSet.remove("5"));


    }

    @Test
    void removeall() {
        stringBinarySearchSet.add("1");
        stringBinarySearchSet.add("2");
        stringBinarySearchSet.add("3");

        stringArrayList.add("1");
        stringArrayList.add("3");

        assertTrue(stringBinarySearchSet.removeAll(stringArrayList));
        assertEquals(stringBinarySearchSet.size(), 1);
        stringArrayList.add("9");

        assertFalse(integerBinarySearchSet.removeAll(integerArrayList));

        integerBinarySearchSet.add(1);
        integerBinarySearchSet.add(2);
        integerBinarySearchSet.add(3);
        integerBinarySearchSet.add(4);
        integerBinarySearchSet.add(5);
        integerArrayList.add(4);
        integerArrayList.add(5);
        integerBinarySearchSet.removeAll(integerArrayList);
        assertEquals(integerBinarySearchSet.size(), 3);
        assertEquals(integerBinarySearchSet.getValue(1), 2);

    }



    @Test
    void toArray() {
        integerBinarySearchSet.add(1);
        integerBinarySearchSet.add(2);
        integerBinarySearchSet.add(3);
        assertEquals(integerBinarySearchSet.toArray()[1], 2);
    }

    @Test
    void iterator() {
        integerBinarySearchSet.add(1);
        integerBinarySearchSet.add(2);
        integerBinarySearchSet.add(3);
        Iterator<Integer> integerIterator = integerBinarySearchSet.iterator();
        assertEquals(integerIterator.next(), 1);
    }

    @Test
    void testContains() {
        int loopTime = 10000;
        long totalTime = 0;
        int size = 1048576;
        for (long i = 0; i < size; i++) {
            integerBinarySearchSet.add(1);
        }
        integerBinarySearchSet.add(2);
        for (int i = 0; i < loopTime; i++) {
            long lasttime = System.nanoTime();
            boolean contains = integerBinarySearchSet.contains(2);
            long currentTime = System.nanoTime();

            totalTime += currentTime - lasttime;
        }
        System.out.println(totalTime / loopTime);
    }
}


