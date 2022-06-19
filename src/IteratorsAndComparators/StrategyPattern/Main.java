package IteratorsAndComparators.StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Person> nameComparator = new TreeSet<>(new LengthNameComparator());
        TreeSet<Person> ageComparator = new TreeSet<>(new AgeComparator());

        int numberOfPersons = Integer.parseInt(scanner.nextLine());

        while (numberOfPersons-- > 0) {
            String[] data = scanner.nextLine().split(" ");

            String name = data[0];
            int age = Integer.parseInt(data[1]);

            nameComparator.add(new Person(name, age));
            ageComparator.add(new Person(name, age));
        }

        nameComparator.forEach(System.out::println);
        ageComparator.forEach(System.out::println);
    }
}
