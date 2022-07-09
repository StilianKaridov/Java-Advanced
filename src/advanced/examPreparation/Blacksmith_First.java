package advanced.examPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith_First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] steel = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] carbon = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();

        Arrays.stream(steel).forEach(steelQueue::offer);
        Arrays.stream(carbon).forEach(carbonStack::push);

        Map<String, Integer> swords = new TreeMap<>();
        swords.put("Gladius", 0);
        swords.put("Shamshir", 0);
        swords.put("Katana", 0);
        swords.put("Sabre", 0);

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int sum = steelQueue.peek() + carbonStack.peek();

            switch (sum) {
                case 70:
                    int getVal = swords.get("Gladius");
                    swords.put("Gladius", getVal + 1);
                    carbonStack.pop();
                    break;
                case 80:
                    getVal = swords.get("Shamshir");
                    swords.put("Shamshir", getVal + 1);
                    carbonStack.pop();
                    break;
                case 90:
                    getVal = swords.get("Katana");
                    swords.put("Katana", getVal + 1);
                    carbonStack.pop();
                    break;
                case 110:
                    getVal = swords.get("Sabre");
                    swords.put("Sabre", getVal + 1);
                    carbonStack.pop();
                    break;
                default:
                    int plusFive = carbonStack.pop();
                    plusFive += 5;
                    carbonStack.push(plusFive);
            }

            steelQueue.poll();
        }

        int forgedSwords = 0;
        for (Map.Entry<String, Integer> entry : swords.entrySet()) {
            forgedSwords += entry.getValue();
        }

        if (forgedSwords != 0) {
            System.out.printf("You have forged %d swords.%n", forgedSwords);
        } else {
            System.out.printf("You did not have enough resources to forge a sword.%n");
        }

        System.out.print("Steel left: ");
        String result = steelQueue.isEmpty() ? "none" : steelQueue.stream().map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.printf(result + "%n");

        System.out.print("Carbon left: ");
        result = carbonStack.isEmpty() ? "none" : carbonStack.stream().map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.printf(result + "%n");

        swords.entrySet()
                .stream()
                .filter(e -> e.getValue() != 0)
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }
}