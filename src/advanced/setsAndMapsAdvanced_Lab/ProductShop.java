package advanced.setsAndMapsAdvanced_Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> shops = new TreeMap<>();

        String[] data = scanner.nextLine().split(", ");
        while (!data[0].equals("Revision")) {
            Map<String, Double> products = new LinkedHashMap<>();
            String shopName = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);
            if (shops.containsKey(shopName)) {
                products = shops.get(shopName);
            }
            products.put(product, price);
            shops.put(shopName, products);

            data = scanner.nextLine().split(", ");
        }

        for (Map.Entry<String, Map<String, Double>> shop : shops.entrySet()) {
            System.out.printf("%s->%n", shop.getKey());
            for (Map.Entry<String, Double> product : shop.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", product.getKey(), product.getValue());
            }
        }

    }
}