package oop.examPreparation.april_18th_2021.spaceStation.models.mission;

import oop.examPreparation.april_18th_2021.spaceStation.models.astronauts.Astronaut;
import oop.examPreparation.april_18th_2021.spaceStation.models.planets.Planet;

import java.util.Collection;

public interface Mission {
    void explore(Planet planet, Collection<Astronaut> astronauts);
}
