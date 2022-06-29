package Advanced.StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("src/Advanced.StreamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] words = bufferedReader.readLine().split(" ");
        LinkedHashMap<String, Integer> countForWords = new LinkedHashMap<>();
        countForWords.put("of", 0);
        countForWords.put("which", 0);
        countForWords.put("The", 0);
        FileReader textReader = new FileReader("src/Advanced.StreamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt");
        Scanner scanner = new Scanner(textReader);
        String[] line = scanner.nextLine().split(" ");
        for (int i = 0; i < line.length; i++) {
            String currentWord = line[i];
            if(countForWords.containsKey(currentWord)){
                int prevCount = countForWords.get(currentWord);
                countForWords.put(currentWord, prevCount + 1);
            }
        }

        try(PrintWriter pw = new PrintWriter("result.txt")){
            countForWords.entrySet().forEach(f->pw.println(f.getKey() + " - " + f.getValue()));
        }
    }
}
