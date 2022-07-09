package oop.workingWithAbstraction.cardsWithPower;

import oop.workingWithAbstraction.cardRank.CardRank;
import oop.workingWithAbstraction.cardSuit.CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        CardSuit cardSuit = CardSuit.valueOf(suit);
        CardRank cardRank = CardRank.valueOf(rank);

        Card card = new Card(cardRank, cardSuit);

        System.out.println(card.toString());
    }
}
