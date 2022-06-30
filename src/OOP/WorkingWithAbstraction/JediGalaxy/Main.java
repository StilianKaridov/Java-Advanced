package OOP.WorkingWithAbstraction.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getInput(scanner.nextLine());

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] field = new int[rows][cols];

        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                field[row][col] = value++;
            }
        }

        String command = scanner.nextLine();
        long sum = 0;

        while (!command.equals("Let the Force be with you")) {

            int[] jediStartingPosition = getInput(command);
            int[] evilStartingPosition = getInput(scanner.nextLine());

            int rowEvil = evilStartingPosition[0];
            int colEvil = evilStartingPosition[1];

            moveEvil(field, rowEvil, colEvil);

            int rowJedi = jediStartingPosition[0];
            int colJedi = jediStartingPosition[1];

            sum = moveJedi(field, sum, rowJedi, colJedi);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static long moveJedi(int[][] field, long sum, int rowJedi, int colJedi) {
        while (rowJedi >= 0 && colJedi < field[1].length) {
            if (rowJedi < field.length && colJedi >= 0 && colJedi < field[0].length) {
                sum += field[rowJedi][colJedi];
            }

            colJedi++;
            rowJedi--;
        }
        return sum;
    }

    private static void moveEvil(int[][] field, int rowEvil, int colEvil) {
        while (rowEvil >= 0 && colEvil >= 0) {
            if (rowEvil < field.length && colEvil < field[0].length) {
                field[rowEvil][colEvil] = 0;
            }
            rowEvil--;
            colEvil--;
        }
    }

    private static int[] getInput(String scanner) {
        return Arrays.stream(scanner.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

}