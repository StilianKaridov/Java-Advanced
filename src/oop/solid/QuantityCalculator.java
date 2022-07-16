package oop.solid;

import oop.solid.products.Chips;
import oop.solid.products.Chocolate;
import oop.solid.products.Coke;
import oop.solid.products.Lemonade;

import java.util.List;

public class QuantityCalculator implements Calculator {

    public QuantityCalculator() {
    }

    @Override
    public double sum(List<Product> products) {
        double sum = 0;

        for (Product product : products) {

            if (product instanceof Coke) {
                double grams = ((Coke) product).getMilliliters() * Coke.DENSITY;
                sum += ((Coke) product).getAmountOfDrinks() * grams;
            }

            if (product instanceof Lemonade) {
                double grams = ((Lemonade) product).getMilliliters() * Lemonade.DENSITY;
                sum += ((Lemonade) product).getAmountOfDrinks() * grams;
            }

            if (product instanceof Chocolate) {
                sum += ((Chocolate) product).getAmountOfFood() * ((Chocolate) product).getGrams();
            }

            if (product instanceof Chips) {
                sum += ((Chips) product).getAmountOfFood() * ((Chips) product).getGrams();
            }
        }

        return sum;
    }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
