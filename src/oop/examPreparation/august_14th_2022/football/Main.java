package oop.examPreparation.august_14th_2022.football;

import oop.examPreparation.august_14th_2022.football.core.Engine;
import oop.examPreparation.august_14th_2022.football.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
