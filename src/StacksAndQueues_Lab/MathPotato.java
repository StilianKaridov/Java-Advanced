package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> players = new ArrayDeque<>();
        String[] names = scanner.nextLine().split("\\s+");
        Collections.addAll(players, names);

        int n = Integer.parseInt(scanner.nextLine());
        int cycle = 1;
        while (players.size() > 1) {
            for (int i = 1; i < n; i++) {
                players.offer(players.poll());
            }
            if (isComposite(cycle)) {
                System.out.println("Removed " + players.poll());
            } else {
                System.out.println("Prime " + players.peek());
            }
            cycle++;
        }
        System.out.println("Last is " + players.poll());

    }

    public static boolean isComposite(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                count++;
        }

        if (count == 2)
            return false;
        else
            return true;
    }
}