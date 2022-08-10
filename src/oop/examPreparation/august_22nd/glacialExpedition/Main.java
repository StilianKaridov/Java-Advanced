package oop.examPreparation.august_22nd.glacialExpedition;

import oop.examPreparation.august_22nd.glacialExpedition.core.Controller;
import oop.examPreparation.august_22nd.glacialExpedition.core.ControllerImpl;
import oop.examPreparation.august_22nd.glacialExpedition.core.Engine;
import oop.examPreparation.august_22nd.glacialExpedition.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
