package advanced.stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String s : input) {
            queue.offer(s);
        }

        ArrayDeque<String> stack = new ArrayDeque<>();
        boolean isBalanced = false;

        label:
        while (!queue.isEmpty()) {
            String currentPopped = queue.poll();
            switch (currentPopped) {
                case "}":
                    if (stack.isEmpty() || !stack.pop().equals("{")) {
                        System.out.println("NO");
                        isBalanced = false;
                        break label;
                    }
                    break;
                case "]":
                    if (stack.isEmpty() || !stack.pop().equals("[")) {
                        System.out.println("NO");
                        isBalanced = false;
                        break label;
                    }
                    break;
                case ")":
                    if (stack.isEmpty() || !stack.pop().equals("(")) {
                        System.out.println("NO");
                        isBalanced = false;
                        break label;
                    }
                    break;
                default:
                    stack.push(currentPopped);
                    break;
            }
            isBalanced = true;
        }

        if (isBalanced) {
            System.out.println("YES");
        }
    }
}