package oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.drivers;

import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.cars.Car;

import static oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.common.ExceptionMessages.CAR_INVALID;
import static oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.common.ExceptionMessages.INVALID_NAME;

public class DriverImpl implements Driver {

    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        setName(name);
        this.numberOfWins = 0;
        this.canParticipate = false;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }

        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(CAR_INVALID);
        }

        this.car = car;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return this.car != null;
    }
}