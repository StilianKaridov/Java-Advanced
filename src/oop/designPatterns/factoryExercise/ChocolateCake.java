package oop.designPatterns.factoryExercise;

public class ChocolateCake extends Cake {
    public ChocolateCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing ChocolateCake");
    }

    @Override
    public void bake() {
        System.out.println("Baking ChocolateCake");
    }

    @Override
    public void box() {
        System.out.println("Boxing ChocolateCake");
    }
}
