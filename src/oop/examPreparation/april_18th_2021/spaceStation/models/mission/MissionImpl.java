package oop.examPreparation.april_18th_2021.spaceStation.models.mission;

import oop.examPreparation.april_18th_2021.spaceStation.models.astronauts.Astronaut;
import oop.examPreparation.april_18th_2021.spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission {

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        Collection<String> planetItems = planet.getItems();

        for (Astronaut a : astronauts) {

            while (a.canBreath() && planetItems.size() != 0) {
                String nextItem = planetItems.iterator().next();

                a.getBag().getItems().add(nextItem);
                a.breath();

                planetItems.remove(nextItem);
            }

        }
    }
}
