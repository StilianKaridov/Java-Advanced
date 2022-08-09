package oop.examPreparation.december_11th.catHouse.repositories;

import oop.examPreparation.december_11th.catHouse.entities.toys.Toy;

public interface Repository {

    void buyToy(Toy toy);

    boolean removeToy(Toy toy);

    Toy findFirst(String type);
}
