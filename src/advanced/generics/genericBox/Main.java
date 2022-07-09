package advanced.generics.genericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box;

        while (n-- > 0) {
            String actualString = scanner.nextLine();
            box = new Box<>(actualString);
            System.out.println(box.toString());
        }
    }
}
