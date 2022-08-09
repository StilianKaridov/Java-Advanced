package oop.examPreparation.december_11th.catHouse.entities.houses;

import oop.examPreparation.december_11th.catHouse.entities.cat.Cat;
import oop.examPreparation.december_11th.catHouse.entities.toys.Toy;

import java.util.Collection;

public interface House {
    int sumSoftness();

    void addCat(Cat cat);

    void removeCat(Cat cat);

    void buyToy(Toy toy);

    void feeding();

    String getStatistics();

    String getName();

    void setName(String name);

    Collection<Cat> getCats();

    Collection<Toy> getToys();
}
