package oop.examPreparation.april_18th.zoo.entities.foods;

public class Meat extends BaseFood {

    private static final int CALORIES = 70;
    private static final double PRICE = 10;

    public Meat() {
        super(CALORIES, PRICE);
    }

    @Override
    public int getCalories() {
        return CALORIES;
    }

    @Override
    public double getPrice() {
        return PRICE;
    }
}
