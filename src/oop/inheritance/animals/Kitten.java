package oop.inheritance.animals;

public class Kitten extends Cat {
    private static final String TYPE = "Female";

    public Kitten(String name, int age) {
        super(name, age, TYPE);
    }

    @Override
    public String produceSound(){
        return "Meow";
    }
}
