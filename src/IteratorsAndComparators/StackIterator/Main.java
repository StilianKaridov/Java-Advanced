package IteratorsAndComparators.StackIterator;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] commands = input.split("\\s+|,\\s+");
            switch (commands[0]) {
                case "Push":
                    Integer[] array = Arrays.stream(commands).skip(1)
                            .map(Integer::parseInt)
                            .toArray(Integer[]::new);
                    stack.push(array);
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

            }
            input = scanner.nextLine();
        }

        stack.print();
        stack.print();

    }
}