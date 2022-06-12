package SetsAndMapsAdvanced_Lab;

import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();
        Set<String> comingToParty = new HashSet<>();

        String reservationNumber = scanner.nextLine();
        while (!reservationNumber.equals("PARTY")) {

            if (reservationNumber.startsWith("\\d")) {
                vip.add(reservationNumber);
            } else {
                regular.add(reservationNumber);
            }
            reservationNumber = scanner.nextLine();
        }

        String numberComing = scanner.nextLine();
        while (!numberComing.equals("END")) {

            if (vip.contains(numberComing)) {
                comingToParty.add(numberComing);
                vip.remove(numberComing);
            } else if (regular.contains(numberComing)) {
                comingToParty.add(numberComing);
                regular.remove(numberComing);
            }
            numberComing = scanner.nextLine();
        }

        System.out.println(vip.size() + regular.size());
        vip.forEach(System.out::println);
        regular.forEach(System.out::println);
    }
}