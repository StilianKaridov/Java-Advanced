package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> nameWithEmail = new LinkedHashMap<>();
        String name = scanner.nextLine();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            nameWithEmail.put(name, email);
            name = scanner.nextLine();
        }
        Map<String, String> fixedEmails = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : nameWithEmail.entrySet()) {
            String currentEmail = entry.getValue().toLowerCase();
            if (!currentEmail.contains(".uk") && !currentEmail.contains(".us") && !currentEmail.contains(".com")) {
                fixedEmails.put(entry.getKey(), entry.getValue());
            }
        }

        if (!fixedEmails.isEmpty()) {
            fixedEmails.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
        }
    }
}