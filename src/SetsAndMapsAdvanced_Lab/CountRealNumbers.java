package SetsAndMapsAdvanced_Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double, Integer> numbers = new LinkedHashMap<>();
        double[] readNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();

        for (double number : readNumbers) {
            if (!numbers.containsKey(number)) {
                numbers.put(number, 1);
            } else {
                int prevCount = numbers.get(number);
                numbers.put(number, prevCount + 1);
            }
        }

        numbers.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}