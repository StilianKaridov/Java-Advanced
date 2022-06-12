package SetsAndMapsAdvanced_Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> parking = new LinkedHashSet<>();
        String[] direction = scanner.nextLine().split(", ");

        while (!direction[0].equals("END")) {
            String carNumber = direction[1];

            switch (direction[0]) {
                case "IN":
                    parking.add(carNumber);
                    break;
                case "OUT":
                    parking.remove(carNumber);
                    break;
            }
            direction = scanner.nextLine().split(", ");
        }

        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parking.forEach(System.out::println);
        }

    }
}