package oop.workingWithAbstraction.trafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] signals = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][signals.length];

        int col = 0;

        for (int i = 0; i < signals.length; i++) {
            Signal current = Signal.valueOf(signals[i]);

            for (int row = 0; row < n; row++) {
                matrix[row][col] = current.getNext();
                current = Signal.valueOf(current.getNext());
            }

            col++;
        }

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String current : arr) {
                System.out.print(current + " ");
            }
            System.out.println();
        }
    }
}
