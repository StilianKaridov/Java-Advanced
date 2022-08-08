package oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.cars;

public class SportsCar extends BaseCar {

    private static final int MINIMUM_HORSE_POWER = 250;
    private static final int MAXIMUM_HORSE_POWER = 450;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, 3000);
        checkIfInRange(horsePower, MINIMUM_HORSE_POWER, MAXIMUM_HORSE_POWER);
    }
}
