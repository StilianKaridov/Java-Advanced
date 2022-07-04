package OOP.Encapsulation.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInfo = scanner.nextLine().split(" ");
        String pizzaName = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo[2]);

        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);

            String[] doughInfo = scanner.nextLine().split(" ");
            String flourType = doughInfo[1];
            String bakingTechnique = doughInfo[2];
            double doughWeight = Double.parseDouble(doughInfo[3]);

            Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
            pizza.setDough(dough);

            String[] toppingInfo = scanner.nextLine().split(" ");
            while (!"END".equals(toppingInfo[0])) {
                String toppingType = toppingInfo[1];
                double toppingWeight = Double.parseDouble(toppingInfo[2]);

                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);

                toppingInfo = scanner.nextLine().split(" ");
            }

            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}