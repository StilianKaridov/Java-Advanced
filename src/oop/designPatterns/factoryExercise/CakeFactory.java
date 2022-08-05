package oop.designPatterns.factoryExercise;

public class CakeFactory {

    public static Cake createCake(String type) {
        Cake cake = null;

        switch (type) {
            case "Biscuit":
                cake = new BiscuitCake(12, 15, 10);
                break;
            case "Chocolate":
                cake = new ChocolateCake(15, 20, 8);
                break;
            case "Spinach":
                cake = new SpinachCake(20, 30, 15);
                break;
            case "White":
                cake = new WhiteCake(25, 30, 20);
                break;
        }

        return cake;
    }
}
