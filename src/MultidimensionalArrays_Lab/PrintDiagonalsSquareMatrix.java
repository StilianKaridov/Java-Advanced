package MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimension = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = currentRow;
        }

        printMainDiagonal(matrix, dimension);
        System.out.println();
        printSecondaryDiagonal(matrix, dimension);
    }

    private static void printSecondaryDiagonal(int[][] matrix, int dimension) {
        int startRow = dimension - 1;
        int startCol = 0;

        int[] diagonal = new int[dimension];
        int index = 0;

        while (startCol != dimension) {
            diagonal[index++] = matrix[startRow][startCol];
            startRow--;
            startCol++;
        }

        for (int number : diagonal) {
            System.out.print(number + " ");
        }
    }

    public static void printMainDiagonal(int[][] matrix, int dimension) {
        int currentIndex = 0;
        int[] diagonal = new int[dimension];

        while (currentIndex != dimension) {
            diagonal[currentIndex] = matrix[currentIndex][currentIndex];
            currentIndex++;
        }

        for (int number : diagonal) {
            System.out.print(number + " ");
        }
    }
}