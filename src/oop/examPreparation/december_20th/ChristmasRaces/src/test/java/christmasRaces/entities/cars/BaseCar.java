package oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.cars;


import static oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;
import static oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car {

    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        setModel(model);
        this.horsePower = horsePower;
        this.cubicCentimeters = cubicCentimeters;
    }

    private void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.length() < 4) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, 4));
        }

        this.model = model;
    }

    protected void checkIfInRange(int horsePower, int min, int max) {
        if (horsePower < min || horsePower > max) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return cubicCentimeters / horsePower * laps;
    }
}
