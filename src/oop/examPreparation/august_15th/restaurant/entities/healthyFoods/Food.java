package oop.examPreparation.august_15th.restaurant.entities.healthyFoods;

import oop.examPreparation.august_15th.restaurant.entities.healthyFoods.interfaces.HealthyFood;

import static oop.examPreparation.august_15th.restaurant.common.ExceptionMessages.*;

public abstract class Food implements HealthyFood {

    private String name;
    private double portion;
    private double price;

    public Food(String name, double portion, double price) {
        setName(name);
        setPortion(portion);
        setPrice(price);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }

        this.name = name;
    }

    private void setPortion(double portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException(INVALID_PORTION);
        }

        this.portion = portion;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }

        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPortion() {
        return portion;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
