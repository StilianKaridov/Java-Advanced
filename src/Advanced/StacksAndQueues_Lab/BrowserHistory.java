package Advanced.StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> urls = new ArrayDeque<>();
        String command = scanner.nextLine();
        String currentURL = "blank";
        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (!urls.isEmpty()) {
                    currentURL = urls.pop();
                } else {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }
            } else {
                if (!currentURL.equals("blank")) {
                    urls.push(currentURL);
                }
                currentURL = command;
            }
            System.out.println(currentURL);
            command = scanner.nextLine();
        }
    }
}