package oop.examPreparation.firstAndSecondTasks.main.java.zoo.core;

import oop.examPreparation.firstAndSecondTasks.main.java.zoo.entities.animals.Animal;
import oop.examPreparation.firstAndSecondTasks.main.java.zoo.entities.animals.AquaticAnimal;
import oop.examPreparation.firstAndSecondTasks.main.java.zoo.entities.animals.TerrestrialAnimal;
import oop.examPreparation.firstAndSecondTasks.main.java.zoo.entities.areas.Area;
import oop.examPreparation.firstAndSecondTasks.main.java.zoo.entities.areas.LandArea;
import oop.examPreparation.firstAndSecondTasks.main.java.zoo.entities.areas.WaterArea;
import oop.examPreparation.firstAndSecondTasks.main.java.zoo.entities.foods.BaseFood;
import oop.examPreparation.firstAndSecondTasks.main.java.zoo.entities.foods.Food;
import oop.examPreparation.firstAndSecondTasks.main.java.zoo.entities.foods.Meat;
import oop.examPreparation.firstAndSecondTasks.main.java.zoo.entities.foods.Vegetable;
import oop.examPreparation.firstAndSecondTasks.main.java.zoo.repositories.FoodRepository;
import oop.examPreparation.firstAndSecondTasks.main.java.zoo.repositories.FoodRepositoryImpl;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static oop.examPreparation.firstAndSecondTasks.main.java.zoo.common.ConstantMessages.*;
import static oop.examPreparation.firstAndSecondTasks.main.java.zoo.common.ExceptionMessages.*;

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
            throw new NullPointerException(INVALID_AREA_TYPE);
        }

        areas.put(areaName, area);

        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        BaseFood food;

        if (foodType.equals("Vegetable")) {
            food = new Vegetable();
        } else if (foodType.equals("Meat")) {
            food = new Meat();
        } else {
            throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }

        foodRepository.add(food);

        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = foodRepository.findByType(foodType);

        if (food == null) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }

        areas.get(areaName).addFood(food);
        foodRepository.remove(food);

        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;

        if (animalType.equals("AquaticAnimal")) {
            animal = new AquaticAnimal(animalName, kind, price);

            if (!areas.get(areaName).getClass().getSimpleName().equals("WaterArea")) {
                return String.format(AREA_NOT_SUITABLE);
            }
        } else if (animalType.equals("TerrestrialAnimal")) {
            animal = new TerrestrialAnimal(animalName, kind, price);

            if (!areas.get(areaName).getClass().getSimpleName().equals("LandArea")) {
                return String.format(AREA_NOT_SUITABLE);
            }
        } else {
            throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }

        areas.get(areaName).addAnimal(animal);

        return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        int fedCount = areas.get(areaName).getAnimals().size();

        areas.get(areaName).feed();

        return String.format(ANIMALS_FED, fedCount);
    }

    @Override
    public String calculateKg(String areaName) {
        double totalKg = 0;

        for (Animal animal : areas.get(areaName).getAnimals()) {
            totalKg += animal.getKg();
        }

        return String.format(KILOGRAMS_AREA, areaName, totalKg);
    }

    @Override
    public String getStatistics() {
        return areas.values().stream()
                .map(Area::getInfo)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
