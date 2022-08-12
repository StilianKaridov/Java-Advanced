package oop.examPreparation.april_18th_2021.spaceStation.core;

import oop.examPreparation.april_18th_2021.spaceStation.models.astronauts.Astronaut;
import oop.examPreparation.april_18th_2021.spaceStation.models.astronauts.Biologist;
import oop.examPreparation.april_18th_2021.spaceStation.models.astronauts.Geodesist;
import oop.examPreparation.april_18th_2021.spaceStation.models.astronauts.Meteorologist;
import oop.examPreparation.april_18th_2021.spaceStation.models.mission.Mission;
import oop.examPreparation.april_18th_2021.spaceStation.models.mission.MissionImpl;
import oop.examPreparation.april_18th_2021.spaceStation.models.planets.Planet;
import oop.examPreparation.april_18th_2021.spaceStation.models.planets.PlanetImpl;
import oop.examPreparation.april_18th_2021.spaceStation.repositories.AstronautRepository;
import oop.examPreparation.april_18th_2021.spaceStation.repositories.PlanetRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static oop.examPreparation.april_18th_2021.spaceStation.common.ConstantMessages.*;
import static oop.examPreparation.april_18th_2021.spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private int exploredPlanetsCount;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.exploredPlanetsCount = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = null;

        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);

        Arrays.stream(items)
                .forEach(i -> planet.getItems().add(i));

        planetRepository.add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.findByName(astronautName);

        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        astronautRepository.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planet = planetRepository.findByName(planetName);

        Collection<Astronaut> capableAstronauts = astronautRepository
                .getModels().stream()
                .filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());

        if (capableAstronauts.size() == 0) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Mission mission = new MissionImpl();
        mission.explore(planet, capableAstronauts);

        long deadAstronautsCount = capableAstronauts.stream()
                .filter(a -> a.getOxygen() == 0)
                .count();

        this.exploredPlanetsCount++;

        return String.format(PLANET_EXPLORED, planetName, deadAstronautsCount);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_PLANET_EXPLORED, exploredPlanetsCount));
        sb.append(System.lineSeparator());

        sb.append(REPORT_ASTRONAUT_INFO);
        sb.append(System.lineSeparator());

        Collection<Astronaut> models = astronautRepository.getModels();

        for (Astronaut model : models) {
            Collection<String> availableItems = model.getBag().getItems();

            String bagItemsOutput = availableItems.size() == 0
                    ? "none"
                    : String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, availableItems);

            sb.append(String.format(REPORT_ASTRONAUT_NAME, model.getName()));
            sb.append(System.lineSeparator());

            sb.append(String.format(REPORT_ASTRONAUT_OXYGEN, model.getOxygen()));
            sb.append(System.lineSeparator());

            sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, bagItemsOutput));
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
