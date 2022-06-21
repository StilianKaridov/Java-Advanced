package ExamPreparation;

import java.util.Scanner;

public class Bomb_Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(",");
        int countCommands = 0;

        char[][] matrix = new char[size][];
        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }

        int bombsOnField = getBombsCount(matrix);
        int currentRow = getStartingPosition(matrix)[0];
        int currentCol = getStartingPosition(matrix)[1];

        while (countCommands++ < commands.length) {
            String currentCommand = commands[countCommands - 1];
            switch (currentCommand) {
                case "left":
                    if (isInBounds(matrix, currentCol - 1)) {
                        currentCol--;
                    }
                    break;
                case "right":
                    if (isInBounds(matrix, currentCol + 1)) {
                        currentCol++;
                    }
                    break;
                case "up":
                    if (isInBounds(matrix, currentRow - 1)) {
                        currentRow--;
                    }
                    break;
                case "down":
                    if (isInBounds(matrix, currentRow + 1)) {
                        currentRow++;
                    }
                    break;
            }

            if (matrix[currentRow][currentCol] == 'B') {
                bombsOnField--;
                matrix[currentRow][currentCol] = '+';
                System.out.println("You found a bomb!");
                if (bombsOnField == 0) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (matrix[currentRow][currentCol] == 'e') {
                System.out.printf("END! %d bombs left on the field", bombsOnField);
                return;
            }

        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombsOnField, currentRow, currentCol);
    }

    private static int getBombsCount(char[][] matrix) {
        int countBombs = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'B') {
                    countBombs++;
                }
            }
        }
        return countBombs;
    }

    public static boolean isInBounds(char[][] field, int index) {
        return index != -1 && index != field.length;
    }

    public static int[] getStartingPosition(char[][] field) {
        int getRow = 0;
        int getCol = 0;
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                if (field[row][col] == 's') {
                    getRow = row;
                    getCol = col;
                    break;
                }
            }
        }
        return new int[]{getRow, getCol};
    }

}