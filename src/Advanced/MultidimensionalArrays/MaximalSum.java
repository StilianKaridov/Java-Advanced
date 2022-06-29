package Advanced.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];
        int countForRows = rows;

        int startRow = 0;
        int startCol = 0;
        while (countForRows > 0) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int number : currentRow) {
                matrix[startRow][startCol++] = number;
            }
            startRow++;
            startCol = 0;

            countForRows--;
        }
        int maxSum = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[3][3];
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                int firstRow = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2];
                int secondRow = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2];
                int thirdRow = matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                int currSum = firstRow + secondRow + thirdRow;

                if (maxSum < currSum) {
                    maxSum = currSum;
                    maxMatrix = new int[][]{
                            {matrix[i][j], matrix[i][j + 1], matrix[i][j + 2]},
                            {matrix[i + 1][j], matrix[i + 1][j + 1], matrix[i + 1][j + 2]},
                            {matrix[i + 2][j], matrix[i + 2][j + 1], matrix[i + 2][j + 2]}
                    };
                }

            }
        }
        System.out.println("Sum = " + maxSum);
        for (int[] arr : maxMatrix) {
            for (int number : arr) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

    }
}