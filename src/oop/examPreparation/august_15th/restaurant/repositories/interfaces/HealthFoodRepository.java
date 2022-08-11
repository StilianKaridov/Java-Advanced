package oop.examPreparation.august_15th.restaurant.repositories.interfaces;

public interface HealthFoodRepository<T> extends Repository<T> {
    T foodByName(String name);
}
