package oop.examPreparation.august_15th.restaurant.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getAllEntities();

    void add(T entity);

}
