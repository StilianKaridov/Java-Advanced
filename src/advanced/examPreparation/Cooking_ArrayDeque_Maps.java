package advanced.examPreparation;

import java.util.*;

public class Cooking_ArrayDeque_Maps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();


        int[] liquidsInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] ingredientsInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Arrays.stream(liquidsInput).forEach(liquidsQueue::offer);
        Arrays.stream(ingredientsInput).forEach(ingredientsStack::push);

        Map<String, Integer> foodsCooked = new TreeMap<>();
        foodsCooked.put("Bread", 0);
        foodsCooked.put("Fruit Pie", 0);
        foodsCooked.put("Cake", 0);
        foodsCooked.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            String toCook = null;
            int liquid = liquidsQueue.peek();
            int ingredient = ingredientsStack.peek();

            int sum = liquid + ingredient;

            if (sum == 100) {
                toCook = "Fruit Pie";
                ingredientsStack.pop();
            } else if (sum == 75) {
                toCook = "Pastry";
                ingredientsStack.pop();
            } else if (sum == 50) {
                toCook = "Cake";
                ingredientsStack.pop();
            } else if (sum == 25) {
                toCook = "Bread";
                ingredientsStack.pop();
            } else {
                int plusThree = ingredientsStack.pop();
                plusThree += 3;
                ingredientsStack.push(plusThree);
            }

            liquidsQueue.poll();

            if (toCook != null) {
                int value = foodsCooked.get(toCook);
                value += 1;
                foodsCooked.put(toCook, value);
            }

        }

        if (!foodsCooked.containsValue(0)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            while (liquidsQueue.size() > 1) {
                System.out.print(liquidsQueue.poll() + ", ");
            }
            System.out.print(liquidsQueue.poll());
            System.out.println();
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            while (ingredientsStack.size() > 1) {
                System.out.print(ingredientsStack.pop() + ", ");
            }
            System.out.print(ingredientsStack.pop());
            System.out.println();
        }

        foodsCooked.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}