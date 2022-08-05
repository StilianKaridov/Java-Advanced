package oop.designPatterns.factoryExercise;

public class SpinachCake extends Cake {
    public SpinachCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing SpinachCake");
    }

    @Override
    public void bake() {
        System.out.println("Baking SpinachCake");
    }

    @Override
    public void box() {
        System.out.println("Boxing SpinachCake");
    }
}
