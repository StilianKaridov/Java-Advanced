package OOP.Encapsulation.ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> persons = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        String[] personsInput = scanner.nextLine().split(";");

        for (String s : personsInput) {
            String[] personData = s.split("=");

            String name = personData[0];
            double money = Double.parseDouble(personData[1]);

            try {
                Person person = new Person(name, money);
                persons.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] productsInput = scanner.nextLine().split(";");

        for (String p : productsInput) {
            String[] productData = p.split("=");

            String name = productData[0];
            double cost = Double.parseDouble(productData[1]);

            try {
                Product product = new Product(name, cost);
                products.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            String[] input = command.split(" ");

            String personName = input[0];
            String productName = input[1];

            Person person = persons.get(personName);
            Product product = products.get(productName);

            try {
                person.buyProduct(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            command = scanner.nextLine();
        }

        persons.values().forEach(System.out::println);
    }
}