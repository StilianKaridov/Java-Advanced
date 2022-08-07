package oop.examPreparation.firstAndSecondTasks.main.java.zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal {

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, 2.50, price);
    }

    @Override
    public void eat() {
         setKg(this.getKg() + 7.50);
    }
}
