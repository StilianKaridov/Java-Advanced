package oop.workingWithAbstraction_Lab.pointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = readArray(scanner);

        Point bottom = new Point(input[0], input[1]);
        Point top = new Point(input[2], input[3]);

        Rectangle rectangle = new Rectangle(bottom, top);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            int[] coordinates = readArray(scanner);

            Point checkIfContains = new Point(coordinates[0], coordinates[1]);

            System.out.println(rectangle.contains(checkIfContains));
        }
    }

    public static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}