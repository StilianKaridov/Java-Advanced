package oop.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnterNumbers {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        int start = 1;
        int end = 100;

        int startCount = 0;

        while (startCount < 10) {
            int number = 0;
            try {
                number = readNumber(start, end);

                numbers.add(number);
                start = number;
                startCount++;
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

    private static int readNumber(int start, int end) {

        int number;
        try {
            number = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid Number!");
        }

        if (number <= start || number >= end) {
            throw new IllegalStateException("Your number is not in range " + start + " - 100!");
        }

        return number;
    }
}