package Advanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (numberOfCommands > 0) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]) {
                case "1":
                    int numberToPush = Integer.parseInt(command[1]);
                    stack.push(numberToPush);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    int max = Integer.MIN_VALUE;
                    ArrayDeque<Integer> toHold = new ArrayDeque<>();
                    while(!stack.isEmpty()){
                        if(stack.peek() > max){
                            max = stack.peek();
                        }
                        int currentPopped = stack.pop();
                        toHold.push(currentPopped);
                    }
                    System.out.println(max);
                    while(!toHold.isEmpty()){
                        stack.push(toHold.pop());
                    }
                    break;
            }
            numberOfCommands--;
        }
    }
}
