package SetsAndMapsAdvanced_Lab;

import java.util.*;

public class CitiesContinentCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, List<String>>> continents = new LinkedHashMap<>();
        int numberOfLines = Integer.parseInt(scanner.nextLine());

        while (numberOfLines-- > 0) {
            String[] data = scanner.nextLine().split(" ");

            String continent = data[0];
            String country = data[1];
            String city = data[2];

            if (!continents.containsKey(continent)) {
                continents.put(continent, new LinkedHashMap<>());
                continents.get(continent).put(country, new ArrayList<>());
                continents.get(continent).get(country).add(city);
            } else {
                if (!continents.get(continent).containsKey(country)) {
                    continents.get(continent).put(country, new ArrayList<>());
                    continents.get(continent).get(country).add(city);
                } else {
                    continents.get(continent).get(country).add(city);
                }
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, List<String>>> continent : continents.entrySet()) {
            System.out.printf("%s:%n", continent.getKey());
            for (Map.Entry<String, List<String>> country : continent.getValue().entrySet()) {
                System.out.printf("  %s -> ", country.getKey());
                System.out.print(String.join(", ", country.getValue()));
                System.out.println();
            }

        }
    }
}