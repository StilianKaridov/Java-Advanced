package SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lengths = scanner.nextLine().split(" ");
        int firstLength = Integer.parseInt(lengths[0]);
        int secondLength = Integer.parseInt(lengths[1]);
        int number;

        Set<Integer> firstSet = new LinkedHashSet<>();
        while (firstLength > 0) {
            number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
            firstLength--;
        }

        Set<Integer> secondSet = new LinkedHashSet<>();
        while (secondLength > 0) {
            number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
            secondLength--;
        }

        firstSet.retainAll(secondSet);

        for (int current : firstSet) {
            System.out.print(current + " ");
        }

    }
}