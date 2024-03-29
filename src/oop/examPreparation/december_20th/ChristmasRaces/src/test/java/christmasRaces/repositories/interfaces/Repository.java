package oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {
    T getByName(String name);

    Collection<T> getAll();

    void add(T model);

    boolean remove(T model);
}
