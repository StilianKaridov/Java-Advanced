package oop.solid;

import oop.solid.products.Chips;
import oop.solid.products.Chocolate;
import oop.solid.products.Coke;
import oop.solid.products.Lemonade;

import java.util.List;

public class CalorieCalculator implements Calculator{

    public CalorieCalculator() {
    }

    @Override
    public double sum(List<Product> products) {
        double sum = 0;

        for (Product product : products) {

            if (product instanceof Coke) {
                double grams = ((Coke) product).getMilliliters() * Coke.DENSITY;
                sum += product.getAmountOfCalories() * grams;
            }

            if (product instanceof Lemonade) {
                double grams = ((Lemonade) product).getMilliliters() * Lemonade.DENSITY;
                sum += product.getAmountOfCalories() * grams;
            }

            if (product instanceof Chocolate) {
                sum += product.getAmountOfCalories() * ((Chocolate) product).getGrams();
            }

            if (product instanceof Chips) {
                sum += product.getAmountOfCalories() * ((Chips) product).getGrams();
            }
        }

        return sum;
    }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
