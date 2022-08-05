package oop.designPatterns.factoryExercise;

public class WhiteCake extends Cake {
    public WhiteCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing WhiteCake");
    }

    @Override
    public void bake() {
        System.out.println("Baking WhiteCake");
    }

    @Override
    public void box() {
        System.out.println("Boxing WhiteCake");
    }
}
