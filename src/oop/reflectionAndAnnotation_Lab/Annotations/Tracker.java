package oop.reflectionAndAnnotation_Lab.Annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {

    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<Tracker> trackerClass) {
        Map<String, List<String>> methodsByAuthor = new HashMap<>();

        Method[] methods = trackerClass.getDeclaredMethods();

        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);

            if (annotation != null) {
                methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor.get(annotation.name()).add(method.getName() + "()");
            }
        }

        for (Map.Entry<String, List<String>> entry : methodsByAuthor.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (String s : entry.getValue()) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }
}
