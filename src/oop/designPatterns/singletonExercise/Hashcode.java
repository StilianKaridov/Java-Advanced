package oop.designPatterns.singletonExercise;

public class Hashcode {
    private static Hashcode instance;
    private String point;

    public Hashcode(String point) {
        this.point = point;
    }

    public static Hashcode getInstance(String point) {
        if (instance == null) {
            instance = new Hashcode(point);
        }

        return instance;
    }
}
