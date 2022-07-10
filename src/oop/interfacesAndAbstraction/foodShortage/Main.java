package oop.interfacesAndAbstraction.foodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Buyer> buyers = new ArrayList<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        while (numberOfPeople-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");

            Buyer buyer = tokens.length == 4
                    ? new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3])
                    : new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);

            buyers.add(buyer);
        }

        String command = scanner.nextLine();

        while (!"End".equals(command)) {
            String finalCommand = command;

            buyers
                    .stream()
                    .filter(b -> b.getName().equals(finalCommand))
                    .forEach(Buyer::buyFood);

            command = scanner.nextLine();
        }

        System.out.println(buyers.stream().mapToInt(Buyer::getFood).sum());
    }
}
