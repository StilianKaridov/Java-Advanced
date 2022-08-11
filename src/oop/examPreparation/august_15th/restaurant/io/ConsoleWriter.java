package oop.examPreparation.august_15th.restaurant.io;

import oop.examPreparation.august_15th.restaurant.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
