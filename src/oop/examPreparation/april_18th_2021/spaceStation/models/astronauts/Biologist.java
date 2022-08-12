package oop.examPreparation.april_18th_2021.spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {

    private static double initialOxygen = 70;

    public Biologist(String name) {
        super(name, initialOxygen);
    }

    @Override
    public void breath() {
        super.setOxygen(Math.max(0, super.getOxygen() - 5));
    }
}
