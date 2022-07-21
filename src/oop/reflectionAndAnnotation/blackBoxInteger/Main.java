package oop.reflectionAndAnnotation.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<BlackBoxInt> reflection = BlackBoxInt.class;

        Scanner scanner = new Scanner(System.in);

        Constructor<BlackBoxInt> constructor = reflection.getDeclaredConstructor();
        constructor.setAccessible(true);

        BlackBoxInt clazz = constructor.newInstance();

        Method[] methods = clazz.getClass().getDeclaredMethods();

        String[] command = scanner.nextLine().split("_");
        while (!"END".equals(command[0])) {
            String[] finalCommand = command;

            Arrays.stream(methods).filter(m -> m.getName().equals(finalCommand[0])).forEach(m -> {
                try {
                    m.setAccessible(true);
                    int number = Integer.parseInt(finalCommand[1]);

                    m.invoke(clazz, number);

                    Field privateField = clazz.getClass().getDeclaredField("innerValue");
                    privateField.setAccessible(true);

                    int resultToPrint = (int) privateField.get(clazz);

                    System.out.println(resultToPrint);
                } catch (IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            });

            command = scanner.nextLine().split("_");
        }
    }
}
