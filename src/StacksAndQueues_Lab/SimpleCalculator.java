package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> calculator = new ArrayDeque<>(Arrays.asList(input));
        int sum = Integer.parseInt(calculator.pop());
        while (!calculator.isEmpty()) {
            int number;
            switch (calculator.pop()) {
                case "+":
                    number = Integer.parseInt(calculator.pop());
                    sum += number;
                    break;
                case "-":
                    number = Integer.parseInt(calculator.pop());
                    sum -= number;
                    break;
            }
        }
        System.out.println(sum);
    }
}