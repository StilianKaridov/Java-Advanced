package oop.reflectionAndAnnotation;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;

public class GettersAndSetters {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Method[] getters = getMethods(methods, g -> g.getName().contains("get"));

        Method[] setters = getMethods(methods, s -> s.getName().contains("set"));

        TreeSet<Method> orderedGetters = new TreeSet<>(Comparator.comparing(Method::getName));
        TreeSet<Method> orderedSetters = new TreeSet<>(Comparator.comparing(Method::getName));

        orderedGetters.addAll(Arrays.asList(getters));
        orderedSetters.addAll(Arrays.asList(setters));

        Function<Class<?>, String> formatType = c -> c == int.class ? "class int" : c.toString();

        for (Method g : orderedGetters) {
            System.out.printf("%s will return %s%n", g.getName(), formatType.apply(g.getReturnType()));
        }

        for (Method s : orderedSetters) {
            System.out.printf("%s and will set field of %s%n", s.getName(), formatType.apply(s.getParameterTypes()[0]));
        }
    }

    private static Method[] getMethods(Method[] methods, Predicate<Method> predicate) {
        return Arrays.stream(methods).filter(predicate).toArray(Method[]::new);
    }
}
