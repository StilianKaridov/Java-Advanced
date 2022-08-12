package oop.examPreparation.april_18th_2021.spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut {

    private static double initialOxygen = 50;

    public Geodesist(String name) {
        super(name, initialOxygen);
    }
}
