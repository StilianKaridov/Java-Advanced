package oop.designPatterns.singletonExercise;

public class HashcodeDemo {
    public static void main(String[] args) {
        Hashcode hash1 = Hashcode.getInstance("2.0");
        System.out.println(hash1.hashCode());

        Hashcode hash2 = Hashcode.getInstance("3.0");
        System.out.println(hash2.hashCode());

        System.out.println(hash1 == hash2);
    }
}
