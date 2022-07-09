package advanced.examPreparation;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vowelsQueue = new ArrayDeque<>();
        ArrayDeque<String> consonantsStack = new ArrayDeque<>();

        String[] firstInput = scanner.nextLine().split(" ");
        String[] secondInput = scanner.nextLine().split(" ");

        Arrays.stream(firstInput).forEach(vowelsQueue::offer);
        Arrays.stream(secondInput).forEach(consonantsStack::push);

        Map<String, Set<Character>> words = new LinkedHashMap<>();
        words.put("pear", new HashSet<>());
        words.put("flour", new HashSet<>());
        words.put("pork", new HashSet<>());
        words.put("olive", new HashSet<>());

        while (!consonantsStack.isEmpty()) {
            String vowel = vowelsQueue.poll();
            String consonant = consonantsStack.pop();


            for (var entry : words.entrySet()) {
                String currentWord = entry.getKey();

                if (currentWord.contains(vowel)) {
                    entry.getValue().add(vowel.charAt(0));
                }

                if (currentWord.contains(consonant)) {
                    entry.getValue().add(consonant.charAt(0));
                }
            }

            vowelsQueue.offer(vowel);
        }

        int wordsFound = 0;
        List<String> foundedWords = new ArrayList<>();
        for (var entry : words.entrySet()) {
            if (entry.getValue().size() == entry.getKey().length()) {
                foundedWords.add(entry.getKey());
                wordsFound++;
            }
        }

        System.out.printf("Words found: %d%n", wordsFound);
        for (String word : foundedWords) {
            System.out.printf("%s%n", word);
        }
    }
}