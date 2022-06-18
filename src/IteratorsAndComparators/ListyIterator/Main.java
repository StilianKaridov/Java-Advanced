package IteratorsAndComparators.ListyIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListyIterator listyIterator = new ListyIterator();

        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("END")) {

            switch (command[0]) {
                case "Create":
                    if (command.length > 1) {
                        String[] toCreate = new String[command.length - 1];
                        for (int i = 1; i < command.length; i++) {
                            toCreate[i - 1] = command[i];
                        }
                        listyIterator.create(toCreate);
                    } else {
                        listyIterator = new ListyIterator();
                    }

                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }
            command = scanner.nextLine().split(" ");
        }
    }
}