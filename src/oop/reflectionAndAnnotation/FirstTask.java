package oop.reflectionAndAnnotation;

import java.util.Arrays;

public class FirstTask {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;
        System.out.println("class " + clazz.getSimpleName());

        Class<?> superClass = clazz.getSuperclass();
        System.out.println("class " + superClass.getTypeName());

        Class<?>[] interfaces = clazz.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);

        Reflection instance = clazz.newInstance();
        System.out.println(instance.toString());
    }
}
