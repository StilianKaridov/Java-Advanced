package oop.examPreparation.april_18th_2021.spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut {

    private static double initialOxygen = 90;

    public Meteorologist(String name) {
        super(name, initialOxygen);
    }
}
