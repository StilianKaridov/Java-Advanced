package oop.examPreparation.august_15th.restaurant.repositories;

import oop.examPreparation.august_15th.restaurant.entities.drinks.interfaces.Beverages;
import oop.examPreparation.august_15th.restaurant.repositories.interfaces.BeverageRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {

    private List<Beverages> beverages;

    public BeverageRepositoryImpl() {
        this.beverages = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return this.beverages
                .stream()
                .filter(b -> b.getName().equals(drinkName) && b.getBrand().equals(drinkBrand))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return this.beverages;
    }

    @Override
    public void add(Beverages entity) {
        this.beverages.add(entity);
    }
}
