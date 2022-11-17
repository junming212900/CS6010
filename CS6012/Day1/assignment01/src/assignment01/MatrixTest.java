package assignment01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
int[][] data1 = {{2,4},{6,8}};
int[][] data2 ={{1,2,3},{4,5,6},};

int[][] data3 = {{1,2},{3,4}};
Matrix matrix1;
Matrix matrix2;
Matrix matrix3;
    @BeforeEach
    void setUp() {
        matrix1 = new Matrix(data1);
        matrix2 = new Matrix(data2);
        matrix3 = new Matrix(data3);
    }

    @AfterEach
    void tearDown() {
        matrix1 = null;
        matrix2 = null;
        matrix3 = null;
    }

    @Test
    void testEquals() {
        assertEquals(false,matrix1.equals(matrix2));
        int[][]temp = {{2,4},{6,8}};
        Matrix test = new Matrix(temp);
        assertEquals(true,matrix1.equals(test));
    }

    @Test
    void testToString() {
        String result1 = "2 4 \n6 8 \n";
        System.out.println(result1);
        assertEquals(result1,matrix1.toString());
        String result2 = "1 2 3 \n4 5 6 \n";
        System.out.println(result2);
        assertEquals(result2,matrix2.toString());
    }

    @Test
    void timesWithBalancedDimensions() {
        int[][] result = { {18,24,30},{38,52,66}};
        Matrix matrix =new Matrix(result);
        assertEquals(matrix, matrix1.times(matrix2));
    }

    @Test
    void timesWithUnbalancedDimensions() {
        assertNull(matrix2.times(matrix3));
    }

    @Test
    void plus() {
        int[][] result = {{3,6},{9,12}};
        Matrix matrix = new Matrix(result);
        assertEquals(matrix,matrix1.plus(matrix3));
    }
    @Test
    void timesWithDifferenceDimensions() {
        assertNull(matrix2.plus(matrix3));
    }
}