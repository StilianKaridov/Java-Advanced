package advanced.functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> string = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        Consumer<String> printer = s -> System.out.println("Sir " + s);
        string.forEach(printer);
    }
}
