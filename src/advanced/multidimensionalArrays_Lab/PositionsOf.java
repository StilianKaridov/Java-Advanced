package advanced.multidimensionalArrays_Lab;

        import java.util.Arrays;
        import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        int number = Integer.parseInt(scanner.nextLine());

        searchForNumber(matrix, number);
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

    private static void searchForNumber(int[][] matrix, int number) {
        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];

                if (currentNumber == number) {
                    isFound = true;
                    System.out.println(row + " " + col);
                }

            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }
}