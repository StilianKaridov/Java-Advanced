package oop.designPatterns.factoryExercise;

public class BiscuitCake extends Cake {
    public BiscuitCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing BiscuitCake");
    }

    @Override
    public void bake() {
        System.out.println("Baking BiscuitCake");
    }

    @Override
    public void box() {
        System.out.println("Boxing BiscuitCake");
    }
}
