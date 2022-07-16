package oop.solid.products;

import oop.solid.Food;
import oop.solid.Product;

public class Chocolate implements Product, Food {

    public static final double CALORIES_PER_100_GRAMS = 575.0;

    private double grams;

    public Chocolate(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    @Override
    public double getAmountOfCalories() {
        return CALORIES_PER_100_GRAMS * grams;
    }

    @Override
    public double getAmountOfFood() {
        return grams / 1_000;
    }
}
