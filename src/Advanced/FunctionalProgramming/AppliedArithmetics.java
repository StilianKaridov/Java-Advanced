package Advanced.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Consumer<Integer> printer = n -> System.out.printf("%d ", n);
        UnaryOperator<List<Integer>> add = numbersList -> numbersList.stream().map(e -> e + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = numbersList -> numbersList.stream().map(e -> e - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = numbersList -> numbersList.stream().map(e -> e * 2).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    numbers.forEach(printer);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}