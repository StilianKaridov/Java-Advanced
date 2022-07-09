package advanced.multidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int sizeOfMatrix = Integer.parseInt(input[0]);
        String patternType = input[1];
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        switch (patternType) {
            case "A":
                matrix = patternA(sizeOfMatrix);
                break;
            case "B":
                matrix = patternB(sizeOfMatrix);
                break;
        }

        print(matrix);
    }

    public static int[][] patternA(int sizeOfMatrix) {
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        int start = 1;
        for (int col = 0; col < sizeOfMatrix; col++) {
            for (int row = 0; row < sizeOfMatrix; row++) {
                matrix[row][col] = start++;
            }
        }
        return matrix;
    }

    public static int[][] patternB(int sizeOfMatrix) {
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        int start = 1;
        for (int col = 0; col < sizeOfMatrix; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < sizeOfMatrix; row++) {
                    matrix[row][col] = start++;
                }
            } else {
                for (int row = sizeOfMatrix - 1; row >= 0; row--) {
                    matrix[row][col] = start++;
                }
            }

        }
        return matrix;
    }

    public static void print(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int number : arr) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
