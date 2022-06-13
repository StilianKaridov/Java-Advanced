package Generics_Lab.GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        String[] strings = ArrayCreator.create(10, "a");
        for (String string : strings) {
                System.out.println(string);
        }

        Integer[] integers = ArrayCreator.create(Integer.class, 5, 2);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
