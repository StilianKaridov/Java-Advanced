package oop.examPreparation.firstAndSecondTasks.main.java.zoo.repositories;

import oop.examPreparation.firstAndSecondTasks.main.java.zoo.entities.foods.Food;

public interface FoodRepository {
    void add(Food food);

    boolean remove(Food food);

    Food findByType(String type);
}
