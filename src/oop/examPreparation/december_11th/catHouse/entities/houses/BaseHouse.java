package oop.examPreparation.december_11th.catHouse.entities.houses;

import oop.examPreparation.december_11th.catHouse.entities.cat.Cat;
import oop.examPreparation.december_11th.catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static oop.examPreparation.december_11th.catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static oop.examPreparation.december_11th.catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House {

    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        return toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (cats.size() == capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }

        cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        List<String> catsNames =  cats.stream().map(Cat::getName).collect(Collectors.toList());

        String catsOutput = cats.isEmpty()
                ? "none"
                : String.join(" ", catsNames);

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s:%n", name, getClass().getSimpleName()));
        sb.append(String.format("Cats: %s%n", catsOutput));
        sb.append(String.format("Toys: %d Softness: %d%n", toys.size(), sumSoftness()));

        return sb.toString().trim();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return Collections.unmodifiableCollection(cats);
    }

    @Override
    public Collection<Toy> getToys() {
        return Collections.unmodifiableCollection(toys);
    }
}
