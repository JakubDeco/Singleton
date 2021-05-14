package sk.kosickaakademia;

import java.util.Arrays;

public class Matrix {
    private static Matrix instance;

    private Matrix(){}

    public static Matrix getInstance(){
        if (instance == null){
            instance = new Matrix();
        }
        return instance;
    }

    public int[][] multiply(int[][] matrixA,int[][] matrixB){
        if (matrixA[0].length != matrixB.length){
            return null;
        }
        int height = matrixA.length;
        int length = matrixB[0].length;
        int[][] result =new int[height][length];
        int sum = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < matrixB[0].length; k++) {
                    sum += matrixA[i][k] * matrixB[k][i];
                }
                result[i][j] = sum;
            }
            sum = 0;
        }

        return result;
    }

    public int mainDiagonal(int[][] matrix){
        int result = 0;
        for (int i = 0; i < matrix.length && i < matrix[0].length; i++) {
            if (i == 0) {
                result = matrix[i][i];
                continue;
            }

            result *= matrix[i][i];
        }

        return result;
    }

    public int antidiagonal(int[][] matrix){
        int result = 0;
        int j = matrix[0].length -1;
        for (int i = 0; i < matrix.length && j >= 0; i++) {
            if (i == 0){
                result = matrix[i][j];
                j--;
                continue;
            }

            result *= matrix[i][j];

            j--;
        }

        return result;
    }

    public static void main(String[] args) {
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
        System.out.println(m.mainDiagonal(matrixB));
        System.out.println(m.antidiagonal(matrixA));
        System.out.println(Arrays.deepToString(m.multiply(matrixA, matrixB)));
    }
}
