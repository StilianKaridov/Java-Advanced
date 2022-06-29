package Advanced.StacksAndQueues;

import java.util.Scanner;

public class RecursiveFibonacci {

    private static long[] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wantedNumber = Integer.parseInt(scanner.nextLine());
        memo = new long[wantedNumber + 1];
        System.out.println(fibonacci(wantedNumber));
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] =
                fibonacci(n - 1) +
                        fibonacci(n - 2);
        return memo[n];
    }
}