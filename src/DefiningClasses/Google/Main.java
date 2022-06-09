package DefiningClasses.Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> persons = new LinkedHashMap<>();
        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("End")) {
            String personName = command[0];

            if(!persons.containsKey(personName)){
                Person person = new Person(personName);
                fillData(command, person);
                persons.put(personName, person);
            } else {
                Person existingPerson = persons.get(personName);
                fillData(command, existingPerson);
            }

            command = scanner.nextLine().split(" ");
        }

        String personToPrint = scanner.nextLine();
        System.out.println(persons.get(personToPrint).toString());
    }

    private static void fillData(String[] data, Person person) {
        switch (data[1]) {
            case "company":
                String companyName = data[2];
                String department = data[3];
                double salary = Double.parseDouble(data[4]);
                person.setCompany(new Company(companyName, department, salary));
                break;
            case "pokemon":
                person.addPokemon(new Pokemon(data[2], data[3]));
                break;
            case "parents":
                person.getParents().add(new Parent(data[2], data[3]));
                break;
            case "children":
                person.getChildren().add(new Child(data[2], data[3]));
                break;
            case "car":
                person.setCar(new Car(data[2], Integer.parseInt(data[3])));
                break;
        }
    }
}
