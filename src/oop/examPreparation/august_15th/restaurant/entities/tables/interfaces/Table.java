package oop.examPreparation.august_15th.restaurant.entities.tables.interfaces;

import oop.examPreparation.august_15th.restaurant.entities.drinks.interfaces.Beverages;
import oop.examPreparation.august_15th.restaurant.entities.healthyFoods.interfaces.HealthyFood;

public interface Table {
    int getTableNumber();

    int getSize();

    int numberOfPeople();

    double pricePerPerson();

    boolean isReservedTable();

    double allPeople();

    void reserve(int numberOfPeople);

    void orderHealthy(HealthyFood food);

    void orderBeverages(Beverages beverages);

    double bill();

    void clear();

    String tableInformation();
}
