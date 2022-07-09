package advanced.functionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Function<int[], Integer> findMin = arr -> Arrays.stream(arr).min().getAsInt();
        int min = findMin.apply(numbers);
        System.out.println(min);
    }
}
