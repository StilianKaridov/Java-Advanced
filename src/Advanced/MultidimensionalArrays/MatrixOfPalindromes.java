package Advanced.MultidimensionalArrays;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrix = fillMatrix(rows, cols);
        print(matrix);
    }

    public static String[][] fillMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        char firstAndLast = 'a';
        char middle = 'a';
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = String.valueOf(firstAndLast) + middle++ + firstAndLast;
            }
            firstAndLast++;
            middle = firstAndLast;
        }
        return matrix;
    }

    public static void print(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String palindrome : arr) {
                System.out.print(palindrome + " ");
            }
            System.out.println();
        }
    }
}
