package oop.examPreparation.firstAndSecondTasks.main.java.zoo.entities.areas;

import oop.examPreparation.firstAndSecondTasks.main.java.zoo.entities.animals.Animal;
import oop.examPreparation.firstAndSecondTasks.main.java.zoo.entities.foods.Food;

import java.util.Collection;

public interface Area {
    String getName();

    Collection<Animal> getAnimals();

    Collection<Food> getFoods();

    int sumCalories();

    void addAnimal(Animal animal);

    void removeAnimal(Animal animal);

    void addFood(Food food);

    void feed();

    String getInfo();
}
