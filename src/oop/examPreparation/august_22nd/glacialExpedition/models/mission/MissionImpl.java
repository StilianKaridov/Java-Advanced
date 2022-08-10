package oop.examPreparation.august_22nd.glacialExpedition.models.mission;

import oop.examPreparation.august_22nd.glacialExpedition.models.explorers.Explorer;
import oop.examPreparation.august_22nd.glacialExpedition.models.states.State;

import java.util.Collection;

public class MissionImpl implements Mission {

    @Override
    public void explore(State state, Collection<Explorer> explorers) {

        for (Explorer e : explorers) {
            while (state.getExhibits().iterator().hasNext() && e.canSearch()) {
                e.search();

                String nextExhibit = state.getExhibits().iterator().next();
                e.getSuitcase().getExhibits().add(nextExhibit);

                state.getExhibits().remove(nextExhibit);
            }
        }

    }
}
