package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String fileName = scanner.nextLine();
        while (!fileName.equals("print")) {
            if (fileName.equals("cancel")) {
                if(queue.isEmpty()){
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queue.poll());
                }

            } else {
                queue.offer(fileName);
            }
            fileName = scanner.nextLine();
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}