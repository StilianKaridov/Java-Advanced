package Advanced.MultidimensionalArrays;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][cols];
        int countForRows = rows;

        int startRow = 0;
        int startCol = 0;
        while (countForRows > 0) {
            String[] currentRow = scanner.nextLine().split(" ");
            for (String number : currentRow) {
                matrix[startRow][startCol++] = number;
            }
            startRow++;
            startCol = 0;

            countForRows--;
        }

        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("END")) {

            boolean isValid = false;
            if (command[0].equals("swap") && command.length == 5) {
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);
                if (row1 < rows && row2 < rows && col1 < cols && col2 < cols && row1 >= 0 && row2 >= 0 && col1 >= 0 && col2 >= 0) {
                    String firstElement = matrix[row1][col1];
                    String secondElement = matrix[row2][col2];
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            if (i == row1 && j == col1) {
                                matrix[i][j] = secondElement;
                            } else if (i == row2 && j == col2) {
                                matrix[i][j] = firstElement;
                            }
                        }
                    }
                    isValid = true;
                }
            }

            if (!isValid) {
                System.out.println("Invalid input!");
            } else {

                for (String[] arr : matrix) {
                    for (String number : arr) {
                        System.out.print(number + " ");
                    }
                    System.out.println();
                }
            }

            command = scanner.nextLine().split(" ");
        }
    }
}