package oop.examPreparation.august_15th.restaurant;

import oop.examPreparation.august_15th.restaurant.core.ControllerImpl;
import oop.examPreparation.august_15th.restaurant.core.EngineImpl;
import oop.examPreparation.august_15th.restaurant.core.interfaces.Controller;
import oop.examPreparation.august_15th.restaurant.entities.drinks.interfaces.Beverages;
import oop.examPreparation.august_15th.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import oop.examPreparation.august_15th.restaurant.entities.tables.interfaces.Table;
import oop.examPreparation.august_15th.restaurant.io.ConsoleReader;
import oop.examPreparation.august_15th.restaurant.io.ConsoleWriter;
import oop.examPreparation.august_15th.restaurant.repositories.BeverageRepositoryImpl;
import oop.examPreparation.august_15th.restaurant.repositories.HealthFoodRepositoryImpl;
import oop.examPreparation.august_15th.restaurant.repositories.TableRepositoryImpl;
import oop.examPreparation.august_15th.restaurant.repositories.interfaces.BeverageRepository;
import oop.examPreparation.august_15th.restaurant.repositories.interfaces.HealthFoodRepository;
import oop.examPreparation.august_15th.restaurant.repositories.interfaces.TableRepository;

public class Main {
    public static void main(String[] args) {
        HealthFoodRepository<HealthyFood> healthFoodRepository = new HealthFoodRepositoryImpl();
        BeverageRepository<Beverages> beverageRepository = new BeverageRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();

        Controller controller = new ControllerImpl(healthFoodRepository, beverageRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
