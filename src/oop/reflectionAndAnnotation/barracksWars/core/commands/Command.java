package oop.reflectionAndAnnotation.barracksWars.core.commands;

import oop.reflectionAndAnnotation.barracksWars.interfaces.Executable;
import oop.reflectionAndAnnotation.barracksWars.interfaces.Repository;
import oop.reflectionAndAnnotation.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data,
                   Repository repository,
                   UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return data;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
