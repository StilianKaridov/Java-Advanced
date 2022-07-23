package oop.exceptions;

import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] range = scanner.nextLine().split("\\s+");

        int start = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);

        System.out.println("Range: [" + start + "..." + end + "]");

        String numberInString = scanner.nextLine();

        while (true) {
            try {
                int number = Integer.parseInt(numberInString);
                System.out.println(isInRange(start, end, number));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + numberInString);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            numberInString = scanner.nextLine();
        }
    }

    private static String isInRange(int start, int end, int number) {
        if (number < start || number > end) {
            throw new IllegalArgumentException("Invalid number: " + number);
        }

        return "Valid number: " + number;
    }
}