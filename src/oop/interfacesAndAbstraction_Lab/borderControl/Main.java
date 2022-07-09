package oop.interfacesAndAbstraction_Lab.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiableList = new ArrayList<>();

        String command = scanner.nextLine();

        while (!"End".equals(command)) {

            String[] tokens = command.split("\\s+");

            Identifiable identifiable = tokens.length == 2
                    ? new Robot(tokens[1], tokens[0])
                    : new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);

            identifiableList.add(identifiable);

            command = scanner.nextLine();
        }

        String fakeIds = scanner.nextLine();

        identifiableList
                .stream()
                .map(Identifiable::getId)
                .filter(i -> i.endsWith(fakeIds))
                .forEach(System.out::println);
    }
}