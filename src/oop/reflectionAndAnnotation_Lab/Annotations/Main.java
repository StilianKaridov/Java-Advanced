package oop.reflectionAndAnnotation_Lab.Annotations;

public class Main {
    public static void main(String[] args) {
        Class<TestClass> clazz = TestClass.class;

        Subject subject = (Subject) clazz.getAnnotation(Subject.class);

        for (String category : subject.categories()) {
            System.out.println(category);
        }
    }
}
