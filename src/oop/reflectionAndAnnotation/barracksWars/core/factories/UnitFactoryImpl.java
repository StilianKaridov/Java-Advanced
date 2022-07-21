package oop.reflectionAndAnnotation.barracksWars.core.factories;

import oop.reflectionAndAnnotation.barracksWars.interfaces.Unit;
import oop.reflectionAndAnnotation.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "oop.reflectionAndAnnotation.barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // TODO: implement for problem 3
        Class<?> reflection = Class.forName(UNITS_PACKAGE_NAME + unitType);

        return (Unit) reflection.getDeclaredConstructor().newInstance();
    }
}
