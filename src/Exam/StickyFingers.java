package Exam;

import java.util.Scanner;

public class StickyFingers {
    private static int row = 0;
    private static int col = 0;
    private static int goldStolen = 0;
    private static boolean isCaught = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int rowCount = 0;

        String[] commands = scanner.nextLine().split(",");


        char[][] matrix = new char[size][];

        while (size-- > 0) {
            matrix[rowCount] = scanner.nextLine().replaceAll(" ", "").toCharArray();
            for (int j = 0; j < matrix[rowCount].length; j++) {
                char currentChar = matrix[rowCount][j];
                if (currentChar == 'D') {
                    row = rowCount;
                    col = j;
                }

            }
            rowCount++;
        }

        int length = commands.length;

        int i = 0;
        while (length-- > 0) {
            switch (commands[i++]) {
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

            if (isCaught) {
                break;
            }

        }

        if (!isCaught) {
            System.out.println("Your last theft has finished successfully with " + goldStolen + "$ in your pocket.");
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void move(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        if (!isInBounds(matrix, nextRow, nextCol)) {
            System.out.println("You cannot leave the town, there is police outside!");
            return;
        }

        char currentChar = matrix[nextRow][nextCol];

        if (currentChar == 'P') {
            System.out.println("You got caught with " + goldStolen + "$, and you are going to jail.");
            matrix[row][col] = '+';
            matrix[nextRow][nextCol] = '#';
            isCaught = true;
            return;
        } else if (currentChar == '$') {
            matrix[nextRow][nextCol] = 'D';
            matrix[row][col] = '+';
            goldStolen += (nextCol * nextRow);
            System.out.println("You successfully stole " + (nextCol * nextRow) + "$.");
        } else {
            matrix[row][col] = '+';
            matrix[nextRow][nextCol] = 'D';
        }

        row = nextRow;
        col = nextCol;
    }

    private static boolean isInBounds(char[][] matrix, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix.length;
    }
}