package Advanced.MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = currentRow;
        }

        int[] wrongIndexes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int wrongRow = wrongIndexes[0];
        int wrongCol = wrongIndexes[1];
        int wrongValue = matrix[wrongRow][wrongCol];

        int[][] secondMatrix = new int[rows][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                secondMatrix[row][col] = matrix[row][col];
            }
        }

        for (int row = 0; row < rows; row++) {
            int sum = 0;
            for (int col = 0; col < secondMatrix[row].length; col++) {
                int currentValue = matrix[row][col];
                if (currentValue == wrongValue) {

                    sum += getUpSum(wrongValue, matrix, row, col);
                    sum += getDownSum(wrongValue, matrix, row, col);
                    sum += getLeftSum(wrongValue, matrix, row, col);
                    sum += getRightSum(wrongValue, matrix, row, col);

                    secondMatrix[row][col] = sum;
                    sum = 0;
                }
            }
        }

        printMatrix(secondMatrix);
    }

    private static int getUpSum(int wrongNumber, int[][] matrix, int row, int col) {
        if (!(row - 1 < 0)) {
            if (matrix[row - 1][col] != wrongNumber) {
                return matrix[row - 1][col];
            }
        }
        return 0;
    }

    private static int getDownSum(int wrongNumber, int[][] matrix, int row, int col) {
        if ((row + 1 < matrix.length)) {
            if ((matrix[row + 1][col] != wrongNumber)) {
                return matrix[row + 1][col];
            }
        }
        return 0;
    }

    private static int getLeftSum(int wrongNumber, int[][] matrix, int row, int col) {
        if (!(col - 1 < 0)) {
            if ((matrix[row][col - 1] != wrongNumber)) {
                return matrix[row][col - 1];
            }
        }
        return 0;
    }

    private static int getRightSum(int wrongNumber, int[][] matrix, int row, int col) {
        if (col + 1 < matrix[0].length) {
            if ((matrix[row][col + 1] != wrongNumber)) {
                return matrix[row][col + 1];
            }
        }
        return 0;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}