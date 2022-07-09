package advanced.stacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> urls = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        String command = scanner.nextLine();
        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (urls.size() > 1) {
                    String currentURL = urls.pop();
                    queue.push(currentURL);
                    System.out.println(urls.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (command.equals("forward")) {
                if (!queue.isEmpty()) {
                    String currentForward = queue.poll();
                    System.out.println(currentForward);
                    urls.push(currentForward);
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                urls.push(command);
                System.out.println(command);
                queue.clear();
            }
            command = scanner.nextLine();
        }
    }
}