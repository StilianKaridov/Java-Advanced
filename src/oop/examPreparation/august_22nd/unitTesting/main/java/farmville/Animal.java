package oop.examPreparation.august_22nd.unitTesting.main.java.farmville;

public class Animal {
    private String type;
    private double energy;

    public Animal(String type, double energy) {
        this.type = type;
        this.energy = energy;
    }

    public String getType() {
        return this.type;
    }

    public double getEnergy() {
        return this.energy;
    }
}
