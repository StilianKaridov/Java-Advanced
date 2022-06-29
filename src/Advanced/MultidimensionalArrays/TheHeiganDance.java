package Advanced.MultidimensionalArrays;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Dealt damage every round
        double roundsDamage = Double.parseDouble(scanner.nextLine());

        //Players HP
        int playerHP = 18500;
        double heiganHP = 3000000;

        //To check if the previous spell was Cloud
        boolean isCloud = false;

        //Player's starting position
        int playerRow = 7;
        int playerCol = 7;

        String spell="";
        while (playerHP > 0 && heiganHP > 0) {
            heiganHP -= roundsDamage;

            if (isCloud) {
                playerHP -= 3500;
                isCloud = false;
            }
            if (playerHP < 0 || heiganHP < 0) break;

            String[] command = scanner.nextLine().split("\\s+");
            String spellName = command[0];
            int row = Integer.parseInt(command[1]);
            int col = Integer.parseInt(command[2]);


            if ((playerRow >= Math.max(0, row - 1) && playerRow <= Math.min(14, row + 1)) && (playerCol >= Math.max(0, col - 1) && playerCol <= Math.min(14, col + 1))) {
                if (playerRow - 1 >= 0 && playerRow - 1 < Math.max(0, row - 1)) {
                    playerRow--;
                } else if (playerCol + 1 <= 14 && playerCol + 1 > Math.min(14, col + 1)) {
                    playerCol++;
                } else if (playerRow + 1 <= 14 && playerRow + 1 > Math.min(14, row + 1)) {
                    playerRow++;
                } else if (playerCol - 1 >= 0 && playerCol - 1 < Math.max(0, col - 1)) {
                    playerCol--;
                } else if(heiganHP>0){
                    switch (spellName) {
                        case "Cloud":
                            playerHP -= 3500;
                            spell = "Plague Cloud";
                            isCloud =true;
                            break;
                        case "Eruption":
                            spell = "Eruption";
                            playerHP -= 6000;
                            break;
                    }
                }
            }

        }

        if (heiganHP > 0) {
            System.out.printf("Heigan: %.2f%n", heiganHP);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerHP > 0) {
            System.out.printf("Player: %d%n", playerHP);
        } else {
            System.out.printf("Player: Killed by %s%n", spell);
        }
        System.out.printf("Final position: %d, %d", playerRow, playerCol);

    }
}
