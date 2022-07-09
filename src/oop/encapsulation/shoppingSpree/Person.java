package oop.encapsulation.shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {
        if (money < product.getCost()) {
            throw new IllegalArgumentException(name + " can't afford " + product.getName());
        }
        System.out.printf("%s bought %s%n", name, product.getName());
        this.products.add(product);
        money = money - product.getCost();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name)
                .append(" - ");

        if (products.isEmpty()) {
            sb.append("Nothing bought");
        } else {
            sb.append(products.stream().map(Product::getName).collect(Collectors.joining(", ")));
        }

        return sb.toString();
    }
}