package FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String[] command = scanner.nextLine().split("\\s+");


        while (!command[0].equals("Party!")) {
            Predicate<String> predicate = getPredicate(command);
            switch (command[0]) {
                case "Remove":
                    names.removeIf(predicate);
                    break;
                case "Double":
                    List<String> peopleToAddAgain = new ArrayList<>();
                    names.stream().filter(predicate).forEach(peopleToAddAgain::add);
                    names.addAll(peopleToAddAgain);
                    break;
            }
            command = scanner.nextLine().split("\\s+");
        }

        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(names);
            System.out.println(String.join(", ", names) + " are going to the party!");
        }
    }

    public static Predicate<String> getPredicate(String[] commandParts) {
        Predicate<String> predicate = null;
        String filterName = commandParts[1];
        String filterCriteria = commandParts[2];

        switch (filterName) {
            case "StartsWith":
                predicate = name -> name.startsWith(filterCriteria);
                break;
            case "EndsWith":
                predicate = name -> name.endsWith(filterCriteria);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(filterCriteria);
                break;
        }
        return predicate;
    }
}