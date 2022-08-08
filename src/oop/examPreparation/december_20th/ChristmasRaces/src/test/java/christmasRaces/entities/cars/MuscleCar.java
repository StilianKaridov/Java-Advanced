package oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.cars;

public class MuscleCar extends BaseCar {

    private static final int MINIMUM_HORSE_POWER = 400;
    private static final int MAXIMUM_HORSE_POWER = 600;

    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, 5000);
        checkIfInRange(horsePower, MINIMUM_HORSE_POWER, MAXIMUM_HORSE_POWER);
    }


}
