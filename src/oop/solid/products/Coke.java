package oop.solid.products;

import oop.solid.Drink;
import oop.solid.Product;

public class Coke implements Product, Drink {

    public static final double CALORIES_PER_100_GRAMS = 44.0;
    public static final double DENSITY = 0.6;

    private double milliliters;

    public Coke(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getAmountOfCalories() {
        return CALORIES_PER_100_GRAMS / 100 * milliliters;
    }

    @Override
    public double getAmountOfDrinks() {
        return (milliliters / 1_000) * DENSITY;
    }
}
