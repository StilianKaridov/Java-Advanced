package oop.examPreparation.april_18th.zoo.repositories;

import oop.examPreparation.april_18th.zoo.entities.foods.Food;

public interface FoodRepository {
    void add(Food food);

    boolean remove(Food food);

    Food findByType(String type);
}
