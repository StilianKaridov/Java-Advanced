package oop.reflectionAndAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HighQualityMistakes {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        TreeSet<Field> orderedFields = new TreeSet<>(Comparator.comparing(Field::getName));
        orderedFields.addAll(List.of(clazz.getDeclaredFields()));

        TreeSet<Method> orderedGetters = new TreeSet<>(Comparator.comparing(Method::getName));
        orderedGetters.addAll(Stream.of(clazz.getDeclaredMethods()).filter(s -> s.getName().contains("get")).collect(Collectors.toList()));

        TreeSet<Method> orderedSetters = new TreeSet<>(Comparator.comparing(Method::getName));
        orderedSetters.addAll(Stream.of(clazz.getDeclaredMethods()).filter(s -> s.getName().contains("set")).collect(Collectors.toList()));

        for (Field f : orderedFields) {
            int modifier = f.getModifiers();
            if (!Modifier.isPrivate(modifier)) {
                System.out.printf("%s must be private!%n", f.getName());
            }
        }

        for (Method g : orderedGetters) {
            int modifier = g.getModifiers();
            if (!Modifier.isPublic(modifier)) {
                System.out.printf("%s have to be public!%n", g.getName());
            }
        }

        for (Method s : orderedSetters) {
            int modifier = s.getModifiers();
            if (!Modifier.isPrivate(modifier)) {
                System.out.printf("%s have to be private!%n", s.getName());
            }
        }
    }
}
