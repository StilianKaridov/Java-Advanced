package advanced.multidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int counter = sizeOfMatrix;
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        int startRow = 0;
        int startCol = 0;
        while (counter > 0) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int number : currentRow) {
                matrix[startRow][startCol++] = number;
            }
            startRow++;
            startCol = 0;

            counter--;
        }

        int sum1 = getPrimaryDiagonalSum(sizeOfMatrix, matrix);
        int sum2 = getSecondaryDiagonalSum(sizeOfMatrix, matrix);

        int diff = getDifference(sum1, sum2);
        System.out.println(diff);
    }

    private static int getDifference(int sum1, int sum2) {
        int diff = sum1 - sum2;
        return Math.abs(diff);
    }

    public static int getPrimaryDiagonalSum(int size, int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int getSecondaryDiagonalSum(int size, int[][] matrix) {
        int sum = 0;
        int col = size - 1;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][col--];
        }
        return sum;
    }
}