package Advanced.StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberToConvert = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> remainders = new ArrayDeque<>();
        if (numberToConvert == 0) {
            System.out.println(0);
        } else {
            while (numberToConvert != 0) {
                int remainder = numberToConvert % 2;
                remainders.push(remainder);
                numberToConvert /= 2;
            }
        }

        while (!remainders.isEmpty()) {
            System.out.print(remainders.pop());
        }
    }
}