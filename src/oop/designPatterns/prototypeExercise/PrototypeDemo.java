package oop.designPatterns.prototypeExercise;

public class PrototypeDemo {
    public static void main(String[] args) {
        Prototype employee1 = new EmployeeRecord(1,"Ivan", "Burgas", 12.00, "Vardar");
        Prototype employee2 = employee1.getClone();

        System.out.println(employee2.toString());
    }
}
