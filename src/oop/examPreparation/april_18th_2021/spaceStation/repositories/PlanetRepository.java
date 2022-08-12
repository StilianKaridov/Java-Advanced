package oop.examPreparation.april_18th_2021.spaceStation.repositories;

import oop.examPreparation.april_18th_2021.spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlanetRepository implements Repository<Planet> {

    private Map<String, Planet> planets;

    public PlanetRepository() {
        this.planets = new LinkedHashMap<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(planets.values());
    }

    @Override
    public void add(Planet model) {
        planets.put(model.getName(), model);
    }

    @Override
    public boolean remove(Planet model) {
        return planets.remove(model.getName(), model);
    }

    @Override
    public Planet findByName(String name) {
        return planets.get(name);
    }
}
