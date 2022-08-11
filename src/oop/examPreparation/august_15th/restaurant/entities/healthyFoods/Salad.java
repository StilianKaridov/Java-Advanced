package oop.examPreparation.august_15th.restaurant.entities.healthyFoods;

public class Salad extends Food {

    private static double InitialSaladPortion = 150;

    public Salad(String name, double price) {
        super(name, InitialSaladPortion, price);
    }
}
