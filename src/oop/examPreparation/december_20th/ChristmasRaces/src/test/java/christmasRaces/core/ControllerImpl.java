package oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.core;


import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.core.interfaces.Controller;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.cars.Car;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.cars.MuscleCar;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.cars.SportsCar;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.drivers.Driver;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.drivers.DriverImpl;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.races.Race;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.races.RaceImpl;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.common.ExceptionMessages.*;
import static oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver driverToCreate = new DriverImpl(driver);

        if (driverRepository.getByName(driver) != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }

        driverRepository.add(driverToCreate);

        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        if (carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }

        Car car = null;
        if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
        } else if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        }

        carRepository.add(car);

        return String.format(CAR_CREATED, type+"Car", model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = driverRepository.getByName(driverName);

        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        Car car = carRepository.getByName(carModel);

        if (car == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        driver.addCar(car);

        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        race.addDriver(driver);

        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);

        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        Collection<Driver> drivers = race.getDrivers();

        if (drivers.size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        List<Driver> sortedDrivers = race.getDrivers().stream().
                sorted((s1, s2) -> Double.compare(s2.getCar().calculateRacePoints(race.getLaps()), s1.getCar().calculateRacePoints(race.getLaps()))).
                collect(Collectors.toList());

        sortedDrivers.get(0).winRace();
        raceRepository.remove(race);

        return String.format("Driver %s wins %s race.%n" +
                        "Driver %s is second in %s race.%n" +
                        "Driver %s is third in %s race.", sortedDrivers.get(0).getName(), raceName,
                sortedDrivers.get(1).getName(), raceName,
                sortedDrivers.get(2).getName(), raceName);
    }

    @Override
    public String createRace(String name, int laps) {
        if (raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }

        Race race = new RaceImpl(name, laps);
        raceRepository.add(race);

        return String.format(RACE_CREATED, name);
    }
}
