package assignment4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortUntilTest {

    ArrayList<Integer> integers = new ArrayList<>();
    ArrayList<String> strings = new ArrayList<>();
    Comparator<Integer> integerComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {

            if (o1 > o2) return 1;
            if (o1 < o2) return -1;
            return 0;
        }
    };
    Comparator<String>stringComparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    };

@BeforeEach
void setUp(){
    integers.add(-5);
    integers.add(12);
    integers.add(22);
    integers.add(56);
    integers.add(-1);
    integers.add(1);
    integers.add(45);
    integers.add(23);
    integers.add(15);


    strings.add("hehe");
    strings.add("cs6012");
    strings.add("string");
    strings.add("integers");
    strings.add("nba");
    strings.add("cba");
    strings.add("fifa");
    strings.add("worldcup");
    strings.add("Agentinais2022worldcupchampon");

}
@AfterEach
    void tearDown(){
    integers =null;
    strings = null;
}
@Test
    void testMerge(){
    SortUtil.mergesort(integers,integerComparator);
    assertEquals(integers.size(),9);
    assertEquals(integers.get(0),-5);
    assertEquals(integers.get(1),-1);
    assertEquals(integers.get(2),1);
    assertEquals(integers.get(3),12);
    assertEquals(integers.get(4),15);
    assertEquals(integers.get(5),22);
    assertEquals(integers.get(6),23);
    assertEquals(integers.get(7),45);
    assertEquals(integers.get(8),56);

    SortUtil.mergesort(strings, stringComparator);
    assertEquals(strings.size(),9);
    assertEquals(strings.get(0),"Agentinais2022worldcupchampon");
    assertEquals(strings.get(1),"cba");
    assertEquals(strings.get(2),"cs6012");
    assertEquals(strings.get(3),"fifa");
    assertEquals(strings.get(4),"hehe");
    assertEquals(strings.get(5),"integers");
    assertEquals(strings.get(6),"nba");
    assertEquals(strings.get(7),"string");
    assertEquals(strings.get(8),"worldcup");
}
    @Test
    void testQuick(){
        SortUtil.quicksort(integers,integerComparator);
        assertEquals(integers.size(),9);
        assertEquals(integers.get(0),-5);
        assertEquals(integers.get(1),-1);
        assertEquals(integers.get(2),1);
        assertEquals(integers.get(3),12);
        assertEquals(integers.get(4),15);
        assertEquals(integers.get(5),22);
        assertEquals(integers.get(6),23);
        assertEquals(integers.get(7),45);
        assertEquals(integers.get(8),56);

        SortUtil.quicksort(strings, stringComparator);
        assertEquals(strings.size(),9);
        assertEquals(strings.get(0),"Agentinais2022worldcupchampon");
        assertEquals(strings.get(1),"cba");
        assertEquals(strings.get(2),"cs6012");
        assertEquals(strings.get(3),"fifa");
        assertEquals(strings.get(4),"hehe");
        assertEquals(strings.get(5),"integers");
        assertEquals(strings.get(6),"nba");
        assertEquals(strings.get(7),"string");
        assertEquals(strings.get(8),"worldcup");
    }
@Test
    void testMergeRuntime(){
    for(int i = 9; i<21 ;i++){
        double size = Math.pow(2,i);
        ArrayList<Integer>bestCase = SortUtil.generateBestCase((int) size);
        ArrayList<Integer>averageCase = SortUtil.generateAverageCase((int) size);
        ArrayList<Integer>worseCase = SortUtil.generateWorstCase((int) size);

        int loops =100;
        long totalTime = 0;
         for (int k = 0; k < loops; k++){
             ArrayList<Integer>test =(ArrayList<Integer>) bestCase.clone();
             long startTime = System.nanoTime();
             SortUtil.mergesort(test,integerComparator);
             long endTime = System.nanoTime();
             totalTime += endTime - startTime;
         }
        System.out.println("merge sort best case running time "+ (int)size+ " "+ totalTime/loops);

         totalTime = 0;
         for( int k = 0 ; k < loops; k++){
             ArrayList<Integer> test = (ArrayList<Integer>) averageCase.clone();
             long startTime = System.nanoTime();
             SortUtil.mergesort(test,integerComparator);
             long endTime = System.nanoTime();
             totalTime += endTime - startTime;
         }
        System.out.println("merge sort average case running time" + (int)size + " "+ totalTime/loops);
        for( int k = 0 ; k < loops; k++){
            ArrayList<Integer> test = (ArrayList<Integer>) worseCase.clone();
            long startTime = System.nanoTime();
            SortUtil.mergesort(test,integerComparator);
            long endTime = System.nanoTime();
            totalTime += endTime - startTime;
        }
        System.out.println("merge sort worst case running time" + (int)size + " "+ totalTime/loops);
    }
}
@Test
void testQuickRuntime(){
    for(int i = 10; i<21 ;i++){
        double size = Math.pow(2,i);
        ArrayList<Integer>bestCase = SortUtil.generateBestCase((int) size);
        ArrayList<Integer>averageCase = SortUtil.generateAverageCase((int) size);
        ArrayList<Integer>worseCase = SortUtil.generateWorstCase((int) size);

        int loops =100;
        long totalTime = 0;
        for (int k = 0; k < loops; k++){
            ArrayList<Integer>test =(ArrayList<Integer>) bestCase.clone();
            long startTime = System.nanoTime();
            SortUtil.mergesort(test,integerComparator);
            long endTime = System.nanoTime();
            totalTime += endTime - startTime;
        }
        System.out.println("quick sort best case running time "+ (int)size+ " "+ totalTime/loops);

        totalTime = 0;
        for( int k = 0 ; k < loops; k++){
            ArrayList<Integer> test = (ArrayList<Integer>) averageCase.clone();
            long startTime = System.nanoTime();
            SortUtil.mergesort(test,integerComparator);
            long endTime = System.nanoTime();
            totalTime += endTime - startTime;
        }
        System.out.println("quick sort average case running time" + (int)size + " "+ totalTime/loops);
        for( int k = 0 ; k < loops; k++){
            ArrayList<Integer> test = (ArrayList<Integer>) worseCase.clone();
            long startTime = System.nanoTime();
            SortUtil.mergesort(test,integerComparator);
            long endTime = System.nanoTime();
            totalTime += endTime - startTime;
        }
        System.out.println("quick sort worst case running time" + (int)size + " "+ totalTime/loops);
    }
}
}


