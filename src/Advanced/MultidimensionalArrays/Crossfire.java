package Advanced.MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        List<List<Integer>> matrix = new ArrayList<>();

        int count = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(count++);
            }
        }

        String[] info = scanner.nextLine().split(" ");
        while (!info[0].equals("Nuke")) {
            int row = Integer.parseInt(info[0]);
            int col = Integer.parseInt(info[1]);
            int radius = Integer.parseInt(info[2]);

            for (int i = row - radius; i <= row + radius; i++) {
                if (isInRange(i, col, matrix) && i != row){
                    matrix.get(i).remove(col);
                }
            }

            for (int i = col + radius; i >= col - radius; i--) {
                if (isInRange(row, i, matrix)){
                    matrix.get(row).remove(i);
                }
            }

            matrix.removeIf(List::isEmpty);
            info = scanner.nextLine().split(" ");
        }

        printMatrix(matrix);
    }

    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    public static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> arr : matrix) {
            for (int current : arr) {
                System.out.print(current + " ");
            }
            System.out.println();
        }
    }
}