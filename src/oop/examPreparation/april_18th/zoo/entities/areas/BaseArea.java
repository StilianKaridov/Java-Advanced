package oop.examPreparation.april_18th.zoo.entities.areas;

import oop.examPreparation.april_18th.zoo.entities.foods.Food;
import oop.examPreparation.april_18th.zoo.entities.animals.Animal;


import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static oop.examPreparation.april_18th.zoo.common.ExceptionMessages.AREA_NAME_NULL_OR_EMPTY;
import static oop.examPreparation.april_18th.zoo.common.ExceptionMessages.NOT_ENOUGH_CAPACITY;

public abstract class BaseArea implements Area {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }

    @Override
    public int sumCalories() {
        return foods
                .stream()
                .mapToInt(Food::getCalories)
                .sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animals.size() == capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }

        animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void feed() {
        animals
                .forEach(Animal::eat);
    }

    @Override
    public String getInfo() {
        String animalOutput = animals.isEmpty()
                ? "none"
                : animals.stream().map(Animal::getName).collect(Collectors.joining(" "));

        return String.format("%s (%s):%n" +
                        "Animals: %s%n" +
                        "Foods: %d%n" +
                        "Calories: %d", name, this.getClass().getSimpleName(),
                animalOutput,
                foods.size(),
                sumCalories());
    }
}
