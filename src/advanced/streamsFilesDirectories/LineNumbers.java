package advanced.streamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("src/Advanced.StreamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        List<String> lines = bufferedReader.lines().toList();
        try (PrintWriter pw = new PrintWriter("src/output.txt")) {
            for (int i = 0; i < lines.size(); i++) {
                pw.println(i + 1 + ". " + lines.get(i));
            }
        }

    }
}
