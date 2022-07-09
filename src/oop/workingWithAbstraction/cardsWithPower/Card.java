package oop.workingWithAbstraction.cardsWithPower;

import oop.workingWithAbstraction.cardRank.CardRank;
import oop.workingWithAbstraction.cardSuit.CardSuit;

public class Card {
    private CardRank cardRank;
    private CardSuit cardSuit;
    private int power;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
        this.power = cardRank.getPower() + cardSuit.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", cardRank.name(), cardSuit.name(), power);
    }
}
