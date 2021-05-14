package sk.kosickaakademia;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @org.junit.jupiter.api.Test
    void multiply() {
        Matrix m = Matrix.getInstance();
        int[][] matrixA = new int[][]{
                {3, 7, 4},
                {2,4,9}
        };
        int[][] matrixB = new int[][]{
                {7,2,9},
                {1,8,5},
                {0,2,4}
        };
        int[][] result = new int[][]{
                {28,72,82},
                {18,54,74}
        };
        assertEquals(result,m.multiply(matrixA,matrixB));
    }
}