package MultidimensionalArrays_Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(rows, cols, scanner);
        char[][] secondMatrix = readMatrix(rows, cols, scanner);

        getEqualElements(firstMatrix, secondMatrix);

        printMatrix(firstMatrix);
    }

    private static char[][] readMatrix(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
        return matrix;
    }

    private static void getEqualElements(char[][] first, char[][] second) {
        for (int row = 0; row < first.length; row++) {

            for (int col = 0; col < first[row].length; col++) {
                char firstMatrixElement = first[row][col];
                char secondMatrixElement = second[row][col];
                if (firstMatrixElement != secondMatrixElement) {
                    first[row][col] = '*';
                }

            }

        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char character : chars) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
    }
}