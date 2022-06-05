package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();
        Consumer<List<Integer>> printer = n -> n.listIterator().forEachRemaining(e -> System.out.print(e + " "));
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add":

                    break;
                case "multiply":
                    break;
                case "subtract":
                    break;
                case "print":
                    printer.accept(numbers);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
        printer.accept(numbers);
    }
}
