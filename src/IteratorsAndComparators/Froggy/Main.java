package IteratorsAndComparators.Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Integer[] numbers = Arrays
                .stream(command.split(", "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Lake lake = new Lake(numbers);

        command = scanner.nextLine();

        List<String> toPrint = new ArrayList<>();
        for (Integer integer : lake) {
            toPrint.add(integer + "");
        }

        System.out.println(String.join(", ", toPrint));
    }
}
