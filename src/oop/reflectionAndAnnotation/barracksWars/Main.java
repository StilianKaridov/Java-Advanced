package oop.reflectionAndAnnotation.barracksWars;

import oop.reflectionAndAnnotation.barracksWars.core.Engine;
import oop.reflectionAndAnnotation.barracksWars.core.factories.UnitFactoryImpl;
import oop.reflectionAndAnnotation.barracksWars.data.UnitRepository;
import oop.reflectionAndAnnotation.barracksWars.interfaces.Repository;
import oop.reflectionAndAnnotation.barracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
