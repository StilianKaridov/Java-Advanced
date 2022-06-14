package Generics.GenericCountMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> list = new ArrayList<>();

        while (n-- > 0) {
            String actualString = scanner.nextLine();
            list.add(actualString);
        }

        String element = scanner.nextLine();
        System.out.println(Box.genericCount(list, element));
    }
}