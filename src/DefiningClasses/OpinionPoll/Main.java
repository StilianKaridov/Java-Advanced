package DefiningClasses.OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        List<Person> persons = new ArrayList<>();

        while (numberOfLines-- > 0) {
            String[] personData = scanner.nextLine().split(" ");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            persons.add(new Person(name, age));
        }

        persons.stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.println(p.toString()));
    }
}
