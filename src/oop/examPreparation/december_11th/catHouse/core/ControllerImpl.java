package oop.examPreparation.december_11th.catHouse.core;

import oop.examPreparation.december_11th.catHouse.entities.cat.Cat;
import oop.examPreparation.december_11th.catHouse.entities.cat.LonghairCat;
import oop.examPreparation.december_11th.catHouse.entities.cat.ShorthairCat;
import oop.examPreparation.december_11th.catHouse.entities.houses.House;
import oop.examPreparation.december_11th.catHouse.entities.houses.LongHouse;
import oop.examPreparation.december_11th.catHouse.entities.houses.ShortHouse;
import oop.examPreparation.december_11th.catHouse.entities.toys.Ball;
import oop.examPreparation.december_11th.catHouse.entities.toys.Mouse;
import oop.examPreparation.december_11th.catHouse.entities.toys.Toy;
import oop.examPreparation.december_11th.catHouse.repositories.ToyRepository;

import java.util.LinkedHashMap;
import java.util.Map;

import static oop.examPreparation.december_11th.catHouse.common.ConstantMessages.*;
import static oop.examPreparation.december_11th.catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Map<String, House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new LinkedHashMap<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;

        switch (type) {
            case "LongHouse":
                house = new LongHouse(name);
                break;
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }

        houses.put(name, house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;

        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }

        toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        toys.removeToy(toy);

        House house = houses.get(houseName);
        house.buyToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        House house = houses.get(houseName);

        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);

                if (!house.getClass().getSimpleName().equals(ShorthairCat.getShortHairCatLivingPlace())) {
                    return UNSUITABLE_HOUSE;
                }

                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);

                if (!house.getClass().getSimpleName().equals(LonghairCat.getLongHairCatLivingPlace())) {
                    return UNSUITABLE_HOUSE;
                }

                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }

        house.addCat(cat);
        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        House house = houses.get(houseName);
        house.feeding();

        return String.format(FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = houses.get(houseName);

        double catsTotalPrice = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double toysTotalPrice = house.getToys().stream().mapToDouble(Toy::getPrice).sum();

        double valueOfTheHouse = catsTotalPrice + toysTotalPrice;

        return String.format(VALUE_HOUSE, houseName, valueOfTheHouse);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (House value : houses.values()) {
            sb.append(value.getStatistics());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
