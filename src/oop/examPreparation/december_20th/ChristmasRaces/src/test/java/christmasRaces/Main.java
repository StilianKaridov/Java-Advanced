package oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces;

import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.core.ControllerImpl;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.core.EngineImpl;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.core.interfaces.Controller;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.cars.Car;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.drivers.Driver;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.entities.races.Race;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.io.ConsoleReader;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.io.ConsoleWriter;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.repositories.CarRepository;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.repositories.DriverRepository;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.repositories.RaceRepository;
import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.repositories.interfaces.Repository;

public class Main {
    public static void main(String[] args) {
        Repository<Car> carRepository = new CarRepository();
        Repository<Race> raceRepository = new RaceRepository();
        Repository<Driver> driverRepository = new DriverRepository();

        Controller controller = new ControllerImpl(driverRepository, carRepository, raceRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
