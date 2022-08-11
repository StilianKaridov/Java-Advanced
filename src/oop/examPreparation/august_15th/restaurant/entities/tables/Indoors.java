package oop.examPreparation.august_15th.restaurant.entities.tables;

public class Indoors extends BaseTable {

    private static double pricePerPerson = 3.50;

    public Indoors(int number, int size) {
        super(number, size, pricePerPerson);
    }
}
