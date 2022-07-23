package oop.exceptions;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int number = Integer.parseInt(scanner.nextLine());

            System.out.printf("%.2f%n", getSquareRoot(number));
        } catch (NumberFormatException e) {
            System.out.println("Invalid");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Goodbye");
        }
    }

    private static double getSquareRoot(int number) {
        double result = Math.sqrt(number);

        if (Double.isNaN(result)) {
            throw new IllegalArgumentException("Invalid");
        }

        return result;
    }
}