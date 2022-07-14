package oop.polymorphism.vehicles;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, tankCapacity);
        setFuelConsumption(1.6 + fuelConsumption);
    }

    @Override
    String printRemainingFuel() {
        return String.format("Truck: %.2f", getFuelQuantity());
    }
}
