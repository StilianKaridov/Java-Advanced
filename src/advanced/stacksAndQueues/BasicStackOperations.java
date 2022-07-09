package advanced.stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputInfo = scanner.nextLine().split("\\s+");
        String[] numbers = scanner.nextLine().split("\\s+");
        int toPush = Integer.parseInt(inputInfo[0]);
        int toPop = Integer.parseInt(inputInfo[1]);
        int toCheck = Integer.parseInt(inputInfo[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < toPush; i++) {
            stack.push(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < toPop; i++) {
            stack.pop();
        }

        int smallest = Integer.MAX_VALUE;

        if (stack.contains(toCheck)) {
            System.out.println(true);
        } else if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            while (!stack.isEmpty()) {
                if (stack.peek() < smallest) {
                    smallest = stack.peek();
                }
                stack.pop();
            }
            System.out.println(smallest);
        }
    }
}