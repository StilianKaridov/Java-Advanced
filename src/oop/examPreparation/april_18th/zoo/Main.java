package oop.examPreparation.april_18th.zoo;

import oop.examPreparation.april_18th.zoo.core.Engine;
import oop.examPreparation.april_18th.zoo.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
