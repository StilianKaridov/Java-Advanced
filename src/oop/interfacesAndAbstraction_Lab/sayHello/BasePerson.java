package oop.interfacesAndAbstraction_Lab.sayHello;

public class BasePerson implements Person{

    private String name;

    protected BasePerson(String name) {
        setName(name);
    }


    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String sayHello() {
        return null;
    }
}
