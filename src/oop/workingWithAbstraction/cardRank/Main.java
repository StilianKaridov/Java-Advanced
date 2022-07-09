package oop.workingWithAbstraction.cardRank;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(input + ":");

        Arrays.stream(CardRank.values()).forEach(c -> System.out.println(c.toString()));
    }
}
