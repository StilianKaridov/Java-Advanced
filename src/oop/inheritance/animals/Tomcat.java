package oop.inheritance.animals;

public class Tomcat extends Cat {
    private static final String TYPE = "Male";

    public Tomcat(String name, int age) {
        super(name, age, TYPE);
    }

    @Override
    public String produceSound(){
        return "MEOW";
    }
}
