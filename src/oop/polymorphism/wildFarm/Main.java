package oop.polymorphism.wildFarm;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();
        List<Food> foods = new ArrayList<>();

        String[] animalInfo = scanner.nextLine().split("\\s+");

        while (!"End".equals(animalInfo[0])) {

            String type = animalInfo[0];
            String animalName = animalInfo[1];
            double animalWeight = Double.parseDouble(animalInfo[2]);
            String livingRegion = animalInfo[3];

            if ("Cat".equals(type)) {
                String breed = animalInfo[4];
                Animal cat = new Cat(animalName, animalWeight, livingRegion, breed);
                animals.add(cat);
            } else if ("Zebra".equals(type)) {
                Animal zebra = new Zebra(animalName, animalWeight, livingRegion);
                animals.add(zebra);
            } else if ("Mouse".equals(type)) {
                Animal mouse = new Mouse(animalName, animalWeight, livingRegion);
                animals.add(mouse);
            } else if ("Tiger".equals(type)) {
                Animal tiger = new Tiger(animalName, animalWeight, livingRegion);
                animals.add(tiger);
            }

            String[] foodInfo = scanner.nextLine().split("\\s+");

            String foodType = foodInfo[0];
            int quantity = Integer.parseInt(foodInfo[1]);

            if ("Vegetable".equals(foodType)) {
                Food vegetable = new Vegetable(quantity);
                foods.add(vegetable);
            } else if ("Meat".equals(foodType)) {
                Food meat = new Meat(quantity);
                foods.add(meat);
            }

            animalInfo = scanner.nextLine().split("\\s+");
        }

        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            Food food = foods.get(i);

            animal.makeSound();
            animal.eat(food);
        }

        animals.forEach(System.out::println);
    }
}
