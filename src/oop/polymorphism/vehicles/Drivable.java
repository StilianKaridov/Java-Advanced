package oop.polymorphism.vehicles;

public interface Drivable {

    String drive(double km);

    default String driveWithoutPeople(double km) {
        return "";
    }
}
