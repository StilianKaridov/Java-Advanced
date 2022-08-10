package oop.examPreparation.august_22nd.glacialExpedition.models.mission;

import oop.examPreparation.august_22nd.glacialExpedition.models.explorers.Explorer;
import oop.examPreparation.august_22nd.glacialExpedition.models.states.State;


import java.util.Collection;

public interface Mission {
    void explore(State state, Collection<Explorer> explorers);
}
