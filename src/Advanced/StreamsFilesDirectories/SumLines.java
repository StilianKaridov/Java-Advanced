package Advanced.StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\stili\\IdeaProjects\\Advanced\\src\\input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine();
        while (line != null) {
            long sum = 0;
            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);
                sum += currentChar;
            }
            System.out.println(sum);
            line = bufferedReader.readLine();
        }
    }
}
