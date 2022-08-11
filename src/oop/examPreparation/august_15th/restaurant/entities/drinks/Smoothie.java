package oop.examPreparation.august_15th.restaurant.entities.drinks;

public class Smoothie extends BaseBeverage {

    private static double smoothiePrice = 4.50;

    public Smoothie(String name, int counter, String brand) {
        super(name, counter, smoothiePrice, brand);
    }
}
