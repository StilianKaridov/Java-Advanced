package advanced.examPreparation;

import java.util.Scanner;

public class MouseAndCheese_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }

        int cheeseCount = 0;
        boolean isOutside = false;

        int mouseRow = getMouseRowPosition(matrix);
        int mouseCol = getMouseColPosition(matrix);

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    if (!isInBounds(matrix, mouseRow - 1)) {
                        isOutside = true;
                        matrix[mouseRow][mouseCol] = '-';
                        break;
                    }
                    mouseRow--;
                    if (matrix[mouseRow][mouseCol] == 'c') {
                        cheeseCount++;
                        matrix[mouseRow][mouseCol] = 'M';
                        matrix[mouseRow + 1][mouseCol] = '-';
                    } else if (matrix[mouseRow][mouseCol] == 'B') {
                        matrix[mouseRow][mouseCol] = 'M';
                        matrix[mouseRow + 1][mouseCol] = '-';
                        continue;
                    } else {
                        matrix[mouseRow][mouseCol] = 'M';
                        matrix[mouseRow + 1][mouseCol] = '-';
                    }

                    break;
                case "down":
                    if (!isInBounds(matrix, mouseRow + 1)) {
                        isOutside = true;
                        matrix[mouseRow][mouseCol] = '-';
                        break;
                    }

                    mouseRow++;
                    if (matrix[mouseRow][mouseCol] == 'c') {
                        cheeseCount++;
                        matrix[mouseRow][mouseCol] = 'M';
                        matrix[mouseRow - 1][mouseCol] = '-';
                    } else if (matrix[mouseRow][mouseCol] == 'B') {
                        matrix[mouseRow][mouseCol] = 'M';
                        matrix[mouseRow - 1][mouseCol] = '-';
                        continue;
                    } else {
                        matrix[mouseRow][mouseCol] = 'M';
                        matrix[mouseRow - 1][mouseCol] = '-';
                    }
                    break;
                case "left":
                    if (!isInBounds(matrix, mouseCol - 1)) {
                        isOutside = true;
                        matrix[mouseRow][mouseCol] = '-';
                        break;
                    }
                    mouseCol--;

                    if (matrix[mouseRow][mouseCol] == 'c') {
                        cheeseCount++;
                        matrix[mouseRow][mouseCol] = 'M';
                        matrix[mouseRow][mouseCol + 1] = '-';
                    } else if (matrix[mouseRow][mouseCol] == 'B') {
                        matrix[mouseRow][mouseCol] = 'M';
                        matrix[mouseRow][mouseCol + 1] = '-';
                        continue;
                    } else {
                        matrix[mouseRow][mouseCol] = 'M';
                        matrix[mouseRow][mouseCol + 1] = '-';
                    }
                    break;
                case "right":
                    if (!isInBounds(matrix, mouseCol + 1)) {
                        isOutside = true;
                        matrix[mouseRow][mouseCol] = '-';
                        break;
                    }
                    mouseCol++;

                    if (matrix[mouseRow][mouseCol] == 'c') {
                        cheeseCount++;
                        matrix[mouseRow][mouseCol] = 'M';
                        matrix[mouseRow][mouseCol - 1] = '-';
                    } else if (matrix[mouseRow][mouseCol] == 'B') {
                        matrix[mouseRow][mouseCol] = 'M';
                        matrix[mouseRow][mouseCol - 1] = '-';
                        continue;
                    } else {
                        matrix[mouseRow][mouseCol] = 'M';
                        matrix[mouseRow][mouseCol - 1] = '-';
                    }
                    break;

            }
            if (isOutside) {
                System.out.println("Where is the mouse?");
                break;
            }

            command = scanner.nextLine();
        }

        if (cheeseCount < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseCount);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseCount);
        }

        printMatrix(matrix);
    }

    public static boolean isInBounds(char[][] matrix, int number) {
        return number != -1 && number != matrix.length;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char current : arr) {
                System.out.print(current);
            }
            System.out.println();
        }
    }

    public static int getMouseRowPosition(char[][] matrix) {
        int mouseRow = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'M') {
                    mouseRow = row;
                    break;
                }

            }
        }
        return mouseRow;
    }

    public static int getMouseColPosition(char[][] matrix) {
        int mouseCol = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'M') {
                    mouseCol = col;
                    break;
                }

            }
        }
        return mouseCol;
    }
}