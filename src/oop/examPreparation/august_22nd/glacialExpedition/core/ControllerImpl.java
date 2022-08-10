package oop.examPreparation.august_22nd.glacialExpedition.core;

import oop.examPreparation.august_22nd.glacialExpedition.models.explorers.AnimalExplorer;
import oop.examPreparation.august_22nd.glacialExpedition.models.explorers.Explorer;
import oop.examPreparation.august_22nd.glacialExpedition.models.explorers.GlacierExplorer;
import oop.examPreparation.august_22nd.glacialExpedition.models.explorers.NaturalExplorer;
import oop.examPreparation.august_22nd.glacialExpedition.models.mission.Mission;
import oop.examPreparation.august_22nd.glacialExpedition.models.mission.MissionImpl;
import oop.examPreparation.august_22nd.glacialExpedition.models.states.State;
import oop.examPreparation.august_22nd.glacialExpedition.models.states.StateImpl;
import oop.examPreparation.august_22nd.glacialExpedition.repositories.ExplorerRepository;
import oop.examPreparation.august_22nd.glacialExpedition.repositories.StateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static oop.examPreparation.august_22nd.glacialExpedition.common.ConstantMessages.*;
import static oop.examPreparation.august_22nd.glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;

        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }

        explorerRepository.add(explorer);
        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);

        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }

        stateRepository.add(state);

        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorerToRetire = explorerRepository.byName(explorerName);

        if (explorerToRetire == null) {
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        }

        explorerRepository.remove(explorerToRetire);

        return String.format(EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        State state = stateRepository.byName(stateName);

        List<Explorer> capableExplorers = explorerRepository.getCollection()
                .stream().filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());

        if (capableExplorers.isEmpty()) {
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        Mission mission = new MissionImpl();
        mission.explore(state, capableExplorers);

        long countRetiredExplorers = capableExplorers.stream()
                .filter(e -> e.getEnergy() == 0)
                .count();

        return String.format(STATE_EXPLORER, stateName, countRetiredExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();

        long exploredStatesCount = stateRepository.getCollection()
                .stream()
                .filter(s -> s.getExhibits().size() == 0)
                .count();
        sb.append(String.format(FINAL_STATE_EXPLORED, exploredStatesCount));
        sb.append(System.lineSeparator());
        sb.append(FINAL_EXPLORER_INFO);
        sb.append(System.lineSeparator());

        List<Explorer> explorers = new ArrayList<>(explorerRepository.getCollection());

        for (Explorer explorer : explorers) {
            sb.append(String.format(FINAL_EXPLORER_NAME, explorer.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(FINAL_EXPLORER_ENERGY, explorer.getEnergy()));
            sb.append(System.lineSeparator());

            String exhibitsOutput = explorer.getSuitcase().getExhibits().size() == 0
                    ? "None"
                    : String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits());

            sb.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, exhibitsOutput));
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
