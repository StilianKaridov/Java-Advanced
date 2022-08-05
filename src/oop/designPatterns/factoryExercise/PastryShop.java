package oop.designPatterns.factoryExercise;

public class PastryShop {
    public static Cake orderCake(String type){
        Cake cake = CakeFactory.createCake(type);
        cake.prepare();
        cake.bake();
        cake.box();

        return cake;
    }
}
