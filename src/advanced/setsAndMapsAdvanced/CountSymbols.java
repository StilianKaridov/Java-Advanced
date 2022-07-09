package advanced.setsAndMapsAdvanced;

import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] text = scanner.nextLine().toCharArray();
        Map<Character, Integer> map = new TreeMap<>();

        for (char current : text) {
            map.put(current, 0);
        }


        for (int i = 0; i < text.length; i++) {
            char currentChar = text[i];
            if (map.containsKey(currentChar)) {
                map.put(currentChar, map.get(currentChar) + 1);
            }

        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}