package oop.polymorphism.vehicles;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, tankCapacity);
        setFuelConsumption(fuelConsumption);
    }

    @Override
    public String driveWithoutPeople(double km) {
        DecimalFormat df = new DecimalFormat("0.##");

        if (fuelQuantity >= getFuelConsumption() * km) {
            fuelQuantity -= getFuelConsumption() * km;
            return String.format("Bus travelled %s km", df.format(km));
        }
        return "Bus needs refueling";
    }

    @Override
    public String drive(double km) {
        DecimalFormat df = new DecimalFormat("0.##");
        setFuelConsumption(getFuelConsumption() + 1.4);

        if (fuelQuantity >= getFuelConsumption() * km) {
            fuelQuantity -= getFuelConsumption() * km;
            return String.format("Bus travelled %s km", df.format(km));
        }
        return "Bus needs refueling";
    }

    @Override
    String printRemainingFuel() {
        return String.format("Bus: %.2f", getFuelQuantity());
    }
}
