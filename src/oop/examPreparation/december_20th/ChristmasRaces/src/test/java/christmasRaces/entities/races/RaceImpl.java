package oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.races;

import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

import static oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race {

    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
        this.drivers = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }

        this.name = name;
    }

    private void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_LAPS);
        }

        this.laps = laps;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver == null) {
            throw new IllegalArgumentException(DRIVER_INVALID);
        }

        if (!driver.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE, driver.getName()));
        }

        boolean doesContain = drivers.stream()
                .anyMatch(d -> d.getName().equals(driver.getName()));

        if (doesContain) {
            throw new IllegalArgumentException(String.format(DRIVER_ALREADY_ADDED, driver.getName(), this.name));
        }

        drivers.add(driver);
    }
}
