package OOP.WorkingWithAbstraction_Lab.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vacationInfo = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(vacationInfo[0]);
        int numberOfDays = Integer.parseInt(vacationInfo[1]);
        Season season = Season.parse(vacationInfo[2]);
        Discount discount = Discount.parse(vacationInfo[3]);

        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, numberOfDays, season, discount);

        System.out.printf("%.2f", priceCalculator.calculatePrice());
    }
}
