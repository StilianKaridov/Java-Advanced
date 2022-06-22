package ExamPreparation;

import java.util.Scanner;

public class Armory_Second {
    private static int row = 0;
    private static int col = 0;
    private static int goldSpent = 0;
    private static boolean isInBounds = true;
    private static int[] firstMirrorCoordinates = new int[2];
    private static int[] secondMirrorCoordinates = new int[2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int rowCount = 0;

        char[][] matrix = new char[size][];

        boolean isFirstMirrorFound = false;

        while (size-- > 0) {

            matrix[rowCount] = scanner.nextLine().replaceAll("", "").toCharArray();
            for (int j = 0; j < matrix[rowCount].length; j++) {
                char currentChar = matrix[rowCount][j];
                if (currentChar == 'A') {
                    row = rowCount;
                    col = j;
                } else if (currentChar == 'M') {
                    if (!isFirstMirrorFound) {
                        firstMirrorCoordinates = new int[]{rowCount, j};
                        isFirstMirrorFound = true;
                    } else {
                        secondMirrorCoordinates = new int[]{rowCount, j};
                    }
                }

            }
            rowCount++;
        }

        String command = scanner.nextLine();

        while (goldSpent < 65) {

            switch (command) {
                case "up":
                    move(matrix, -1, 0);
                    break;
                case "down":
                    move(matrix, 1, 0);
                    break;
                case "right":
                    move(matrix, 0, 1);
                    break;
                case "left":
                    move(matrix, 0, -1);
                    break;
            }

            if (!isInBounds) {
                break;
            } else if (goldSpent >= 65) {
                break;
            }

            command = scanner.nextLine();
        }

        if (!isInBounds) {
            System.out.println("I do not need more swords!");
        } else if (goldSpent >= 65) {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", goldSpent);

        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void move(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        if (!isInBounds(matrix, nextRow, nextCol)) {
            matrix[row][col] = '-';
            isInBounds = false;
            return;
        }

        char currentChar = matrix[nextRow][nextCol];

        if (Character.isDigit(currentChar)) {
            goldSpent += Character.getNumericValue(currentChar);
            matrix[nextRow][nextCol] = 'A';
            matrix[row][col] = '-';
        } else if (currentChar == 'M') {
            matrix[row][col] = '-';
            matrix[nextRow][nextCol] = '-';

            if (nextRow == firstMirrorCoordinates[0] && nextCol == firstMirrorCoordinates[1]) {
                nextRow = secondMirrorCoordinates[0];
                nextCol = secondMirrorCoordinates[1];
            } else {
                nextRow = firstMirrorCoordinates[0];
                nextCol = firstMirrorCoordinates[1];
            }

            matrix[nextRow][nextCol] = 'A';
        } else {
            matrix[nextRow][nextCol] = 'A';
            matrix[row][col] = '-';
        }

        row = nextRow;
        col = nextCol;
    }

    private static boolean isInBounds(char[][] matrix, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix.length;
    }
}