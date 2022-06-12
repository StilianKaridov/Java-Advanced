package SetsAndMapsAdvanced_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        numbers.stream().sorted((n1, n2) -> Integer.compare(n2, n1)).limit(3).forEach(n -> System.out.print(n + " "));
    }
}