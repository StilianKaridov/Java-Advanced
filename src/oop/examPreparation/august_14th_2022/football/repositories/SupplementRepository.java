package oop.examPreparation.august_14th_2022.football.repositories;

import oop.examPreparation.august_14th_2022.football.entities.supplement.Supplement;

public interface SupplementRepository {
    void add(Supplement supplement);

    boolean remove(Supplement supplement);

    Supplement findByType(String type);
}
