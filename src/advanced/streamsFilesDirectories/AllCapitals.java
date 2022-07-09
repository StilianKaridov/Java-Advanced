package advanced.streamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Stream;

public class AllCapitals {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("src/input.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        Stream<String> line = bufferedReader.lines();
        try (PrintWriter printWriter = new PrintWriter("src/output.txt")) {
            List<String> list = line.toList();
            for (String s : list) {
                printWriter.println(s.toUpperCase());
            }
        }

    }
}
