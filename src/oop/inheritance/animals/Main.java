package oop.inheritance.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        List<Animal> animals = new ArrayList<>();

        String animalType = "";

        String[] command = scanner.nextLine().split("\\s+");

        while (!"Beast!".equals(command[0])) {
            if (count % 2 == 0) {
                animalType = command[0];
            } else {
                String name = command[0];
                int age = Integer.parseInt(command[1]);
                String gender = command[2];

                try {
                    switch (animalType) {
                        case "Dog":
                            animals.add(new Dog(name, age, gender));
                            break;
                        case "Cat":
                            animals.add(new Cat(name, age, gender));
                            break;
                        case "Frog":
                            animals.add(new Frog(name, age, gender));
                            break;
                        case "Kitten":
                            animals.add(new Kitten(name, age));
                            break;
                        case "Tomcat":
                            animals.add(new Tomcat(name, age));
                            break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            }

            command = scanner.nextLine().split("\\s+");
            count++;
        }


        animals.forEach(System.out::println);
    }
}
