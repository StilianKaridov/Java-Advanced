package oop.reflectionAndAnnotation.barracksWars.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	String retire(String unitType) throws ExecutionControl.NotImplementedException, ClassNotFoundException;
}
