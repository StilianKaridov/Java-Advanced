package oop.examPreparation.april_18th_2021.spaceStation;

import oop.examPreparation.april_18th_2021.spaceStation.core.Controller;
import oop.examPreparation.april_18th_2021.spaceStation.core.ControllerImpl;
import oop.examPreparation.april_18th_2021.spaceStation.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();

        EngineImpl engine = new EngineImpl(controller);
        engine.run();
    }
}
