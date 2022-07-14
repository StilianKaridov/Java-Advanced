package oop.polymorphism.vehicles;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, tankCapacity);
        setFuelConsumption(0.9 + fuelConsumption);
    }

    @Override
    String printRemainingFuel() {
        return String.format("Car: %.2f", getFuelQuantity());
    }
}
