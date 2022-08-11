package oop.examPreparation.august_15th.restaurant.entities.tables;

import oop.examPreparation.august_15th.restaurant.entities.drinks.interfaces.Beverages;
import oop.examPreparation.august_15th.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import oop.examPreparation.august_15th.restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static oop.examPreparation.august_15th.restaurant.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {

    private Collection<HealthyFood> healthyFoods;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.healthyFoods = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.number = number;
        setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.isReservedTable = false;
    }

    private void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }

        this.size = size;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }

        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.isReservedTable = true;
        setNumberOfPeople(numberOfPeople);
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFoods.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double healthyFoodSum = healthyFoods.stream()
                .mapToDouble(HealthyFood::getPrice)
                .sum();

        double beveragesSum = beverages.stream()
                .mapToDouble(Beverages::getPrice)
                .sum();

        return healthyFoodSum + beveragesSum + (pricePerPerson * numberOfPeople);
    }

    @Override
    public void clear() {
        healthyFoods.clear();
        beverages.clear();
        this.isReservedTable = false;
        this.numberOfPeople = 0;
    }

    @Override
    public String tableInformation() {
        return String.format("Table - %d%n" +
                "Size - %d%n" +
                "Type - %s%n" +
                "All price - %.2f", number, size, this.getClass().getSimpleName(), pricePerPerson);
    }
}
