package oop.polymorphism.vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle implements Drivable, Refuelable {

    protected double fuelQuantity;
    protected static double FUEL_CONSUMPTION;
    protected double tankCapacity;

    public Vehicle(double fuelQuantity, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        this.tankCapacity = tankCapacity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public static double getFuelConsumption() {
        return FUEL_CONSUMPTION;
    }

    public static void setFuelConsumption(double fuelConsumption) {
        FUEL_CONSUMPTION = fuelConsumption;
    }

    @Override
    public String drive(double km) {
        DecimalFormat df = new DecimalFormat("0.##");

        if (fuelQuantity >= getFuelConsumption() * km) {
            fuelQuantity -= getFuelConsumption() * km;
            return String.format("%s travelled %s km", getClass().getSimpleName(), df.format(km));
        }
        return String.format("%s needs refueling", getClass().getSimpleName());
    }

    @Override
    public void refuel(double refuel) {
        if (refuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (refuel + getFuelQuantity() > getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        setFuelQuantity(refuel + getFuelQuantity());
    }

    abstract String printRemainingFuel();
}
