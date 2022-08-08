package oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.races;

import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.drivers.Driver;

import java.util.Collection;

public interface Race {
    String getName();

    int getLaps();

    Collection<Driver> getDrivers();

    void addDriver(Driver driver);
}
