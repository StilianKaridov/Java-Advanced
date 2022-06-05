package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = Arrays.stream(scanner.nextLine().split(" ")).toList();
        Consumer<String> printer = System.out::println;
        strings.forEach(printer);
    }
}