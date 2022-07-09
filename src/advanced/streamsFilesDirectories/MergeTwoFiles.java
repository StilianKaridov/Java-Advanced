package advanced.streamsFilesDirectories;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws FileNotFoundException {
        Path input1 = Paths.get("src/Advanced.StreamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt");
        Path input2 = Paths.get("src/Advanced.StreamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt");
        Path output = Paths.get("result.txt");
        try {
            List<String> dataInput1 = Files.readAllLines(input1);
            List<String> dataInput2 = Files.readAllLines(input2);
            Files.write(output, dataInput1, StandardOpenOption.APPEND);
            Files.write(output, dataInput2, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
