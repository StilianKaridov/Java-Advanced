package SetsAndMapsAdvanced;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, HashSet<String>> players = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split(": ");

        while (!input[0].equals("JOKER")) {
            String name = input[0];
            String[] cardsInfo = input[1].split(", ");
            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());
            }

            for (String card : cardsInfo) {
                players.get(name).add(card);
            }

            input = scanner.nextLine().split(": ");
        }

        for (var player : players.entrySet()) {
            int points = 0;
            for (String cardInfo : player.getValue()) {
                points += getPower(cardInfo.substring(0, cardInfo.length() - 1), String.valueOf(cardInfo.charAt(cardInfo.length() - 1)));
            }

            System.out.printf("%s: %d%n", player.getKey(), points);
        }

    }

    public static int getPower(String power, String type) {
        switch (power) {
            case "J":
                power = "11";
                break;
            case "Q":
                power = "12";
                break;
            case "K":
                power = "13";
                break;
            case "A":
                power = "14";
                break;
        }

        switch (type) {
            case "S":
                type = "4";
                break;
            case "H":
                type = "3";
                break;
            case "D":
                type = "2";
                break;
            case "C":
                type = "1";
                break;
        }
        return Integer.parseInt(power) * Integer.parseInt(type);
    }
}