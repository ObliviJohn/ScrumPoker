package poker;

public class Card {
	private int value;
	private Suits suit;

	public Card(int value, Suits suit) {
		this.value = value;
		this.suit = suit;
	}

	public int getValue() {
		return value;

	}

	public Suits getSuit() {
		return suit;

	}

	@Override
	public String toString() {
		return this.value + " " + this.suit;
	}
}
