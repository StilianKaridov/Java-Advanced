package Advanced.IteratorsAndComparators.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();

        String[] commands = scanner.nextLine().split(" ");

        while (!commands[0].equals("END")) {
            String name = commands[0];
            int age = Integer.parseInt(commands[1]);
            String town = commands[2];

            personList.add(new Person(name, age, town));


            commands = scanner.nextLine().split(" ");
        }

        int index = Integer.parseInt(scanner.nextLine());
        Person person = personList.get(index - 1);
        int equal = 0;

        for (Person current : personList) {
            if(current.compareTo(person) > 0){
                equal++;
            }
        }

        if(equal > 1){
            System.out.printf("%d %d %d", equal, personList.size() - equal, personList.size());
        } else {
            System.out.println("No matches");
        }

    }
}
