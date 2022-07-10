package oop.interfacesAndAbstraction.firstThreeTasks;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //First two tasks

//        Class[] citizenInterfaces = Citizen.class.getInterfaces();
//        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
//                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
//            Method[] methods = Birthable.class.getDeclaredMethods();
//            Method[] methods1 = Identifiable.class.getDeclaredMethods();
//            Scanner scanner = new Scanner(System.in);
//            String name = scanner.nextLine();
//            int age = Integer.parseInt(scanner.nextLine());
//            String id = scanner.nextLine();
//            String birthDate = scanner.nextLine();
//            Identifiable identifiable = new Citizen(name,age,id,birthDate);
//            Birthable birthable = new Citizen(name,age,id,birthDate);
//            System.out.println(methods.length);
//            System.out.println(methods[0].getReturnType().getSimpleName());
//            System.out.println(methods1.length);
//            System.out.println(methods1[0].getReturnType().getSimpleName());
//        }

        //Third task

        List<Birthable> birthableList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!"End".equals(command)) {

            String[] tokens = command.split("\\s+");

            Birthable birthable = tokens[0].equals("Citizen")
                    ? new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4])
                    : new Pet(tokens[1], tokens[2]);

            birthableList.add(birthable);

            command = scanner.nextLine();
        }

        String year = scanner.nextLine();

        birthableList
                .stream()
                .map(Birthable::getBirthDate)
                .filter(b->b.endsWith(year))
                .forEach(System.out::println);
    }
}
