package src;

public class Card {
    private int value;
    private Suit suit;

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }
}
