package oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.drivers;


import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.cars.Car;

public interface Driver {
    String getName();

    Car getCar();

    int getNumberOfWins();

    void addCar(Car car);

    void winRace();

    boolean getCanParticipate();
}
