package oop.examPreparation.april_18th_2021.spaceStation.models.astronauts;

import oop.examPreparation.april_18th_2021.spaceStation.models.bags.Bag;

public interface Astronaut {
    String getName();

    double getOxygen();

    boolean canBreath();

    Bag getBag();

    void breath();
}
