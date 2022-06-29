package Advanced.DefiningClasses.PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split(" ");
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!command[0].equals("Tournament")) {

            String trainerName = command[0];
            String pokemonName = command[1];
            String pokemonElement = command[2];
            int health = Integer.parseInt(command[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, health);
            Trainer trainer = new Trainer(trainerName);

            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).addPokemonToList(pokemon);

            command = scanner.nextLine().split(" ");
        }

        command = scanner.nextLine().split(" ");

        while (!command[0].equals("End")) {
            String element = command[0];

            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {

                List<Pokemon> currentElement = entry.getValue().getPokemonList()
                        .stream()
                        .filter(p -> p.getElement().equals(element)).collect(Collectors.toList());

                if (currentElement.isEmpty()) {
                    entry.getValue()
                            .getPokemonList()
                            .forEach(p -> p.setHealth(p.getHealth() - 10));

                    entry.getValue()
                            .getPokemonList()
                            .removeIf(p -> p.getHealth() <= 0);
                } else {
                    entry.getValue()
                            .setNumberOfBadges(entry.getValue().getNumberOfBadges() + 1);
                }
            }
            command = scanner.nextLine().split(" ");
        }

        trainers.entrySet().stream()
                .sorted((t1,t2) -> Integer.compare(t2.getValue().getNumberOfBadges(), t1.getValue().getNumberOfBadges()))
                .forEach(k -> System.out.println(k.getValue().toString()));
    }
}
