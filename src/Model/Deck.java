package videopoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import videopoker.Card;

public class Deck {
	public List<Card> cards;

	public Deck() {
		this.cards = new ArrayList<Card>();
		createCards();
	}

	public void createCards() {

		cards.clear();
		for (Suits cardSuits : Suits.values()) {
			for (int i = 1; i <= 13; ++i) {
				cards.add(new Card(i, cardSuits));
			}
		}
		shuffle();
	}

	public Card draw() {

		cards.get(0);
		return cards.remove(0);

	}

	public void shuffle() {

		Collections.shuffle(cards);
	}
}
