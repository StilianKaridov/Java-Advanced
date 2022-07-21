package oop.reflectionAndAnnotation.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Class<?> clazz = RichSoilLand.class;
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!"HARVEST".equals(command)) {
            Field[] fields = clazz.getDeclaredFields();

            switch (command) {
                case "protected":
                    printFieldByModifier(fields, "protected");
                    break;
                case "private":
                    printFieldByModifier(fields, "private");
                    break;
                case "public":
                    printFieldByModifier(fields, "public");
                    break;
                case "all":
                    Arrays.stream(fields).forEach(f -> {
                        int modifier = f.getModifiers();

                        System.out.printf("%s %s %s%n", Modifier.toString(modifier), f.getType().getSimpleName(), f.getName());
                    });
                    break;
            }

            command = scanner.nextLine();
        }
    }

    private static void printFieldByModifier(Field[] fields, String modifierType) {
        for (Field f : fields) {
            int modifiers = f.getModifiers();
            String modifier = Modifier.toString(modifiers);

            if (modifier.contains(modifierType)) {
                System.out.printf("%s %s %s%n", modifier, f.getType().getSimpleName(), f.getName());
            }
        }
    }

}
