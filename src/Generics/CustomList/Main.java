package Generics.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> customList = new CustomList<>();

        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("END")) {

            switch (command[0]) {
                case "Add":
                    String element = command[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(command[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    element = command[1];
                    System.out.println(customList.contains(element));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(command[1]);
                    int secondIndex = Integer.parseInt(command[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    element = command[1];
                    System.out.println(customList.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.print();
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
            }
            command = scanner.nextLine().split(" ");
        }

    }
}
