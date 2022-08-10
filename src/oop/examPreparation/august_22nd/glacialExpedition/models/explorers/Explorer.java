package oop.examPreparation.august_22nd.glacialExpedition.models.explorers;

import oop.examPreparation.august_22nd.glacialExpedition.models.suitcases.Suitcase;

public interface Explorer {
    String getName();

    double getEnergy();

    boolean canSearch();

    Suitcase getSuitcase();

    void search();
}
