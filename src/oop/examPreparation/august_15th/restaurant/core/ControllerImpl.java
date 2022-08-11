package oop.examPreparation.august_15th.restaurant.core;

import oop.examPreparation.august_15th.restaurant.core.interfaces.Controller;
import oop.examPreparation.august_15th.restaurant.entities.drinks.Fresh;
import oop.examPreparation.august_15th.restaurant.entities.drinks.Smoothie;
import oop.examPreparation.august_15th.restaurant.entities.drinks.interfaces.Beverages;
import oop.examPreparation.august_15th.restaurant.entities.healthyFoods.Salad;
import oop.examPreparation.august_15th.restaurant.entities.healthyFoods.VeganBiscuits;
import oop.examPreparation.august_15th.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import oop.examPreparation.august_15th.restaurant.entities.tables.InGarden;
import oop.examPreparation.august_15th.restaurant.entities.tables.Indoors;
import oop.examPreparation.august_15th.restaurant.entities.tables.interfaces.Table;
import oop.examPreparation.august_15th.restaurant.repositories.interfaces.BeverageRepository;
import oop.examPreparation.august_15th.restaurant.repositories.interfaces.HealthFoodRepository;
import oop.examPreparation.august_15th.restaurant.repositories.interfaces.TableRepository;

import static oop.examPreparation.august_15th.restaurant.common.ExceptionMessages.*;
import static oop.examPreparation.august_15th.restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;

    private double totalMoney;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
        this.totalMoney = 0;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood food = type.equals("Salad") ? new Salad(name, price) : new VeganBiscuits(name, price);

        if (healthFoodRepository.foodByName(name) != null) {
            throw new IllegalArgumentException(String.format(FOOD_EXIST, name));
        }

        this.healthFoodRepository.add(food);

        return String.format(FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverages = type.equals("Fresh") ? new Fresh(name, counter, brand)
                : new Smoothie(name, counter, brand);

        if (beverageRepository.beverageByName(name, brand) != null) {
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));
        }

        beverageRepository.add(beverages);

        return String.format(BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = type.equals("Indoors") ? new Indoors(tableNumber, capacity)
                : new InGarden(tableNumber, capacity);

        if (tableRepository.byNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(TABLE_IS_ALREADY_ADDED, tableNumber));
        }

        tableRepository.add(table);

        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table table = tableRepository
                .getAllEntities()
                .stream()
                .filter(t -> !t.isReservedTable())
                .filter(t -> t.getSize() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        if (table == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        table.reserve(numberOfPeople);
        return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = tableRepository.byNumber(tableNumber);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        HealthyFood healthyFood = healthFoodRepository.foodByName(healthyFoodName);

        if (healthyFood == null) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        }

        table.orderHealthy(healthyFood);
        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = tableRepository.byNumber(tableNumber);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        Beverages beverage = beverageRepository.beverageByName(name, brand);

        if (beverage == null) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        }

        table.orderBeverages(beverage);
        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = tableRepository.byNumber(tableNumber);
        double bill = table.bill();

        this.totalMoney += bill;

        table.clear();

        return String.format(BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {
        return String.format(TOTAL_MONEY, totalMoney);
    }
}
