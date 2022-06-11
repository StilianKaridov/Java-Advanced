package MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        if (checkIfEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean checkIfEqual(int[][] first, int[][] second) {

        if (first.length != second.length) {
            return false;
        } else {
            for (int row = 0; row < first.length; row++) {
                if (first[row].length != second[row].length) {
                    return false;
                }

                for (int col = 0; col < first[row].length; col++) {
                    if (first[row][col] != second[row][col]) {
                        return false;
                    }
                }

            }
        }

        return true;
    }

    private static int[][] readMatrix(Scanner scanner) {
        String[] dimensions = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] data = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = data;
        }

        return matrix;
    }
}