import org.junit.AfterClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestFindSmallestDiff {
    private int[] arr1, arr2, arr3,arr4,arr5;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        //happens once per test run.
    }

    @BeforeEach
    public void setUp() throws Exception {
        // happens before every test method.
        arr1 = new int[0];
        arr2 = new int[] { 3, 3, 3 };
        arr3 = new int[] { 52, 4, -8, 0, -17 };
        arr4 = new int[]{234,211,231,2121,212,111,50,4,2,1};
        arr5 = new int[]{1,2,3,4,45,60,70,80};
    }

    @Test
    public void emptyArray() {

        assertEquals(-1, DiffUtil.findSmallestDiff(arr1));
    }

    @Test
    public void allArrayElementsEqual() {

        assertEquals(0, DiffUtil.findSmallestDiff(arr2));
    }

    @Test
    public void smallRandomArrayElements() {

        assertEquals(-8, DiffUtil.findSmallestDiff(arr3));
    }
    @Test
    public void largeRandomArrayElement(){
        assertEquals(-1910,DiffUtil.findSmallestDiff(arr4));
    }

    @Test
    public void RegualerRandomArrayElement(){
        assertEquals(-79,DiffUtil.findSmallestDiff(arr5));
    }

    @AfterEach
    public void tearDown() throws Exception {
        // happens right after every Test.
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        // happens once per class, after all test methods have been run.
    }

    private void someHelperMethodUsedInManyTests(){
    }
}
