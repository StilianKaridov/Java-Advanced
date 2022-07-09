package advanced.functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Function<List<Integer>, Integer> findSmallestIndex = list -> {
            int minElement = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= minElement) {
                    minElement = list.get(i);
                    index = i;
                }
            }
            return index;
        };
        System.out.println(findSmallestIndex.apply(integers));
    }
}