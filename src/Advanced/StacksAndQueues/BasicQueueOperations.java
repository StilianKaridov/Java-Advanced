package Advanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputInfo = scanner.nextLine().split("\\s+");
        String[] numbers = scanner.nextLine().split("\\s+");

        int toPush = Integer.parseInt(inputInfo[0]);
        int toPop = Integer.parseInt(inputInfo[1]);
        int toCheck = Integer.parseInt(inputInfo[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < toPush; i++) {
            queue.offer(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < toPop; i++) {
            queue.poll();
        }

        int smallest = Integer.MAX_VALUE;

        if (queue.contains(toCheck)) {
            System.out.println(true);
        } else if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            while (!queue.isEmpty()) {
                if (queue.peek() < smallest) {
                    smallest = queue.peek();
                }
                queue.poll();
            }
            System.out.println(smallest);
        }
    }
}
