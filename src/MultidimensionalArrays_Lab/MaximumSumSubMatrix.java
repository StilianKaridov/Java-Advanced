package MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumSubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = new int[rowsAndCols[0]][rowsAndCols[1]];

        for (int row = 0; row < rowsAndCols[0]; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = currentRow;
        }

        int[][] subMatrix = getSubMatrix(matrix);
        int sum = 0;
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                System.out.print(subMatrix[row][col] + " ");
                sum += subMatrix[row][col];
            }
            System.out.println();
        }
        System.out.println(sum);
    }

    public static int[][] getSubMatrix(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int[][] subMatrix = new int[2][2];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row < matrix.length - 1 && col < matrix[row].length - 1) {

                    int leftUp = matrix[row][col];
                    int rightUp = matrix[row][col + 1];
                    int leftDown = matrix[row + 1][col];
                    int rightDown = matrix[row + 1][col + 1];
                    int subMatrixSum = leftUp + rightUp + leftDown + rightDown;
                    if (maxSum < subMatrixSum) {
                        maxSum = subMatrixSum;
                        subMatrix = new int[][]{
                                {leftUp, rightUp},
                                {leftDown, rightDown}
                        };
                    }

                }
            }
        }

        return subMatrix;
    }

}