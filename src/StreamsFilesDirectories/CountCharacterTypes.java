package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("src/input.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        int countVowels = 0;
        int countPunctuations = 0;
        int countConsonants = 0;

        int read = bufferedReader.read();
        while (read >= 0) {
            char currentChar = (char) read;
            if (isVowel(currentChar)) {
                countVowels++;
            } else if (isPunctuation(currentChar)) {
                countPunctuations++;
            } else if (!Character.isWhitespace(currentChar) && !Character.isDigit(currentChar)) {
                countConsonants++;
            }
            read = bufferedReader.read();
        }
        try(PrintWriter printWriter = new PrintWriter("src/output.txt");){
            printWriter.println("Vowels: " + countVowels);
            printWriter.println("Consonants: " + countConsonants);
            printWriter.println("Punctuation: " + countPunctuations);
        }

    }

    public static boolean isVowel(char character) {
        return character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u';
    }

    public static boolean isPunctuation(char character) {
        return character == ',' || character == '.' || character == '!' || character == '?';
    }
}
