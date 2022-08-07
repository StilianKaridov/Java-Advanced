package oop.examPreparation.firstAndSecondTasks.main.java.zoo;

import oop.examPreparation.firstAndSecondTasks.main.java.zoo.core.Engine;
import oop.examPreparation.firstAndSecondTasks.main.java.zoo.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
