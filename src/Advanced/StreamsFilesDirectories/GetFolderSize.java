package Advanced.StreamsFilesDirectories;

import java.io.File;
import java.util.ArrayDeque;

public class GetFolderSize {
    public static void main(String[] args) {
        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(new File("src/Advanced.StreamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources"));
        int sum = 0;
        while (!queue.isEmpty()) {
            File currentFile = queue.poll();
            File[] nestedFiles = currentFile.listFiles();
            for (File file : nestedFiles) {
                if (file.isDirectory()) {
                    queue.offer(file);
                } else {
                    sum += file.length();
                }
            }
        }
        System.out.println("Folder size: " + sum);
    }
}
