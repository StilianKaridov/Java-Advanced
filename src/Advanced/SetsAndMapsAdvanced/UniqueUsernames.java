package Advanced.SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> usernames = new LinkedHashSet<>();
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        while (numberOfCommands > 0) {
            String username = scanner.nextLine();
            usernames.add(username);
            numberOfCommands--;
        }

        for (String current : usernames) {
            System.out.println(current);
        }
    }
}