package advanced.setsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCompounds = Integer.parseInt(scanner.nextLine());
        TreeSet<String> compounds = new TreeSet<>();
        while (numberOfCompounds > 0) {
            String[] currentRow = scanner.nextLine().split(" ");
            compounds.addAll(Arrays.asList(currentRow));
            numberOfCompounds--;
        }
        System.out.print(String.join(" ", compounds));
    }
}