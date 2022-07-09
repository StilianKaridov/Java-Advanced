package advanced.exam;

import java.util.*;

public class ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] first = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();

        double[] second = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();

        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();

        Arrays.stream(first).forEach(milkQueue::offer);
        Arrays.stream(second).forEach(cacaoStack::push);

        Map<String, Integer> types = new TreeMap<>();
        types.put("Milk Chocolate", 0);
        types.put("Dark Chocolate", 0);
        types.put("Baking Chocolate", 0);
        //cacao percentage = cacao / (milk + cacao)

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double cacao = cacaoStack.pop();
            double milk = milkQueue.poll();

            double sum = (cacao / (milk + cacao)) * 100;

            if (sum == 30.0) {
                types.put("Milk Chocolate", types.get("Milk Chocolate") + 1);
            } else if (sum == 50.0) {
                types.put("Dark Chocolate", types.get("Dark Chocolate") + 1);
            } else if (sum == 100.0) {
                types.put("Baking Chocolate", types.get("Baking Chocolate") + 1);
            } else {
                double plusTen = milk;
                plusTen += 10;
                milkQueue.addLast(plusTen);
            }

        }

        boolean allPrepared = true;
        for (Map.Entry<String, Integer> entry : types.entrySet()) {
            if (entry.getValue() == 0) {
                allPrepared = false;
                break;
            }
        }

        if (allPrepared) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for (Map.Entry<String, Integer> entry : types.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue());
            }

        }

    }
}