package Advanced.FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> divisible = list.stream().filter(e -> e % n != 0).collect(Collectors.toList());
        Collections.reverse(divisible);
        divisible.forEach(e -> System.out.print(e + " "));
    }
}
