package Advanced.SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new LinkedHashMap<>();
        String[] info = scanner.nextLine().split("-");
        while (!info[0].equals("search")) {
            String name = info[0];
            String phoneNumber = info[1];
            phonebook.put(name, phoneNumber);
            info = scanner.nextLine().split("-");
        }

        String nameSearching = scanner.nextLine();
        while (!nameSearching.equals("stop")) {
            if (phonebook.containsKey(nameSearching)) {
                System.out.printf("%s -> %s%n", nameSearching, phonebook.get(nameSearching));
            } else {
                System.out.printf("Contact %s does not exist.%n", nameSearching);
            }
            nameSearching = scanner.nextLine();
        }
    }
}