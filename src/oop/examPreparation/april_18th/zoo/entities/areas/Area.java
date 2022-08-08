package oop.examPreparation.april_18th.zoo.entities.areas;

import oop.examPreparation.april_18th.zoo.entities.foods.Food;
import oop.examPreparation.april_18th.zoo.entities.animals.Animal;

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
