package oop.examPreparation.december_11th.catHouse;

import oop.examPreparation.december_11th.catHouse.core.Engine;
import oop.examPreparation.december_11th.catHouse.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
