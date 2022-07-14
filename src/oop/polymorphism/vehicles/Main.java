package oop.polymorphism.vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));

        String[] truckInfo = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));

        String[] busInfo = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));


        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        while (numberOfCommands-- > 0) {
            String[] command = scanner.nextLine().split("\\s+");

            switch (command[0]) {
                case "Drive":
                    if (command[1].equals("Car")) {
                        System.out.println(car.drive(Double.parseDouble(command[2])));
                    } else if (command[1].equals("Truck")) {
                        System.out.println(truck.drive(Double.parseDouble(command[2])));
                    } else {
                        System.out.println(bus.drive(Double.parseDouble(command[2])));
                    }
                    break;
                case "DriveEmpty":
                    System.out.println(bus.driveWithoutPeople(Double.parseDouble(command[2])));
                    break;
                case "Refuel":
                    try {
                        if (command[1].equals("Car")) {
                            car.refuel(Double.parseDouble(command[2]));
                        } else if (command[1].equals("Truck")) {
                            truck.refuel(Double.parseDouble(command[2]));
                        } else {
                            bus.refuel(Double.parseDouble(command[2]));
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f", bus.getFuelQuantity());
    }
}
