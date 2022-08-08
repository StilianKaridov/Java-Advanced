package oop.examPreparation.April_18th.zoo.core;

import oop.examPreparation.April_18th.zoo.common.ConstantMessages;
import oop.examPreparation.April_18th.zoo.common.ExceptionMessages;
import oop.examPreparation.April_18th.zoo.entities.areas.Area;
import oop.examPreparation.April_18th.zoo.entities.areas.LandArea;
import oop.examPreparation.April_18th.zoo.entities.areas.WaterArea;
import oop.examPreparation.April_18th.zoo.entities.foods.BaseFood;
import oop.examPreparation.April_18th.zoo.entities.foods.Food;
import oop.examPreparation.April_18th.zoo.entities.foods.Meat;
import oop.examPreparation.April_18th.zoo.entities.animals.Animal;
import oop.examPreparation.April_18th.zoo.entities.animals.AquaticAnimal;
import oop.examPreparation.April_18th.zoo.entities.animals.TerrestrialAnimal;
import oop.examPreparation.April_18th.zoo.entities.foods.Vegetable;
import oop.examPreparation.April_18th.zoo.repositories.FoodRepository;
import oop.examPreparation.April_18th.zoo.repositories.FoodRepositoryImpl;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;
    private Map<String, Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new LinkedHashMap<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;

        if (areaType.equals("WaterArea")) {
            area = new WaterArea(areaName);
        } else if (areaType.equals("LandArea")) {
            area = new LandArea(areaName);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }

        areas.put(areaName, area);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        BaseFood food;

        if (foodType.equals("Vegetable")) {
            food = new Vegetable();
        } else if (foodType.equals("Meat")) {
            food = new Meat();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }

        foodRepository.add(food);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = foodRepository.findByType(foodType);

        if (food == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
        }

        areas.get(areaName).addFood(food);
        foodRepository.remove(food);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;

        if (animalType.equals("AquaticAnimal")) {
            animal = new AquaticAnimal(animalName, kind, price);

            if (!areas.get(areaName).getClass().getSimpleName().equals("WaterArea")) {
                return String.format(ConstantMessages.AREA_NOT_SUITABLE);
            }
        } else if (animalType.equals("TerrestrialAnimal")) {
            animal = new TerrestrialAnimal(animalName, kind, price);

            if (!areas.get(areaName).getClass().getSimpleName().equals("LandArea")) {
                return String.format(ConstantMessages.AREA_NOT_SUITABLE);
            }
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }

        areas.get(areaName).addAnimal(animal);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        int fedCount = areas.get(areaName).getAnimals().size();

        areas.get(areaName).feed();

        return String.format(ConstantMessages.ANIMALS_FED, fedCount);
    }

    @Override
    public String calculateKg(String areaName) {
        double totalKg = 0;

        for (Animal animal : areas.get(areaName).getAnimals()) {
            totalKg += animal.getKg();
        }

        return String.format(ConstantMessages.KILOGRAMS_AREA, areaName, totalKg);
    }

    @Override
    public String getStatistics() {
        return areas.values().stream()
                .map(Area::getInfo)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
