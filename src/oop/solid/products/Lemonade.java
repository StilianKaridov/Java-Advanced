package oop.solid.products;

import oop.solid.Drink;
import oop.solid.Product;

public class Lemonade implements Product, Drink {

    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    private double milliliters;

    public Lemonade(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getAmountOfCalories() {
        return CALORIES_PER_100_GRAMS * milliliters;
    }

    @Override
    public double getAmountOfDrinks() {
        return (milliliters / 1_000) * DENSITY;
    }
}
