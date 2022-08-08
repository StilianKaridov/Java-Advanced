package oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.io;

import oop.examPreparation.december_20th.ChristmasRaces.src.test.java.christmasRaces.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
