package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> players = new ArrayDeque<>();
        String[] names = scanner.nextLine().split("\\s+");
        Collections.addAll(players, names);

        int n = Integer.parseInt(scanner.nextLine());
        while (players.size() > 1) {
            for (int i = 1; i < n; i++) {
                players.offer(players.poll());
            }
            System.out.println("Removed " + players.poll());
        }
        System.out.println("Last is " + players.poll());
    }
}