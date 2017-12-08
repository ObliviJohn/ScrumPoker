package testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.AssumptionViolatedException;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.MethodSorters;
import org.junit.runners.model.Statement;

import Model.Card;
import Model.Deck;
import Model.Evaluator;
import Model.Hand;
import Model.Suits;
import Model.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DeckTest {

	Deck deck = new Deck();
	Evaluator eval = new Evaluator();
	User user = new User();
	Hand hand = new Hand();
	
	@Rule
	public TestRule testWatcher = new TestWatcher() {

		@Override
		public Statement apply(Statement base, Description description) {
			return super.apply(base, description);
		}

		@Override
		protected void succeeded(Description description) {
			System.out.println("Test " + description.getDisplayName() + " passed.");
		}

		@Override
		protected void failed(Throwable e, Description description) {
			System.out.println("Test " + description.getDisplayName() + " failed.");
		}

		@Override
		protected void skipped(AssumptionViolatedException e, Description description) {
			System.out.println("Test " + description.getDisplayName() + " skipped.");
		}

		@Override
		protected void starting(Description description) {
			super.starting(description);
			System.out.println("Test " + description.getDisplayName() + " Started.");
		}

		@Override
		protected void finished(Description description) {
			super.finished(description);
			System.out.println("Test " + description.getDisplayName() + " finished.\n");
		}
	};
	
	@Test
	public void fiveCardsOnHand() {
		int cards = 0;
		List<Card> cardHand = hand.getHand();
		for (int i = 0; i < cardHand.size(); i++ ) {
			cards++;
		}
		assertEquals(5, cards);
	}
	
	@Test
	public void money() {
		user.setMoney(100);
		assertEquals(100, user.getMoney());
	}

	@Test
	public void duplicateCard() {
		Set<Card> newDeck = new HashSet<>();
		for (int i = 0; i < deck.cards.size(); i++) {
			newDeck.add(deck.cards.get(i));
		}
		assertEquals(newDeck.size(), deck.cards.size());
	}

	@Test
	public void deckHas52Cards() {
		assertEquals(52, deck.cards.size());
	}
	
	@Test
	public void twoPairs() {
		Card card = new Card(1, Suits.CLUBS);
		Card card2 = new Card(1, Suits.DIAMONDS);
		Card card3 = new Card(2, Suits.HEARTS);
		Card card4 = new Card(2, Suits.SPADES);
		Card card5 = new Card(3, Suits.DIAMONDS);
		ArrayList<Card> cHand = new ArrayList<Card>();
		cHand.add(card);
		cHand.add(card2);
		cHand.add(card3);
		cHand.add(card4);
		cHand.add(card5);
		eval.handEv(cHand);
		assertEquals(2, eval.getScore());
	}
	
	@Test
	public void pair() {
		Card card = new Card(1, Suits.CLUBS);
		Card card2 = new Card(1, Suits.DIAMONDS);
		Card card3 = new Card(9, Suits.HEARTS);
		Card card4 = new Card(2, Suits.SPADES);
		Card card5 = new Card(3, Suits.DIAMONDS);
		ArrayList<Card> cHand = new ArrayList<Card>();
		cHand.add(card);
		cHand.add(card2);
		cHand.add(card3);
		cHand.add(card4);
		cHand.add(card5);
		eval.handEv(cHand);
		assertEquals(1, eval.getScore());
	}
	
	@Test
	public void threeOfAKind() {
		Card card = new Card(1, Suits.CLUBS);
		Card card2 = new Card(1, Suits.DIAMONDS);
		Card card3 = new Card(1, Suits.HEARTS);
		Card card4 = new Card(2, Suits.SPADES);
		Card card5 = new Card(3, Suits.DIAMONDS);
		ArrayList<Card> cHand = new ArrayList<Card>();
		cHand.add(card);
		cHand.add(card2);
		cHand.add(card3);
		cHand.add(card4);
		cHand.add(card5);
		eval.handEv(cHand);
		assertEquals(3, eval.getScore());
	}
	
	@Test
	public void straight() {
		Card card = new Card(10, Suits.CLUBS);
		Card card2 = new Card(11, Suits.DIAMONDS);
		Card card3 = new Card(12, Suits.HEARTS);
		Card card4 = new Card(13, Suits.SPADES);
		Card card5 = new Card(1, Suits.DIAMONDS);
		ArrayList<Card> cHand = new ArrayList<Card>();
		cHand.add(card);
		cHand.add(card2);
		cHand.add(card3);
		cHand.add(card4);
		cHand.add(card5);
		eval.handEv(cHand);
		assertEquals(4, eval.getScore());
	}
	
	@Test
	public void straightFlush() {
		Card card = new Card(10, Suits.CLUBS);
		Card card2 = new Card(11, Suits.CLUBS);
		Card card3 = new Card(12, Suits.CLUBS);
		Card card4 = new Card(13, Suits.CLUBS);
		Card card5 = new Card(1, Suits.CLUBS);
		ArrayList<Card> cHand = new ArrayList<Card>();
		cHand.add(card);
		cHand.add(card2);
		cHand.add(card3);
		cHand.add(card4);
		cHand.add(card5);
		eval.handEv(cHand);
		assertEquals(9, eval.getScore());
	}
	
	@Test
	public void asserNotNull() {
		assertNotNull(deck.cards);
	}
	
	@Test
	public void fullHouse() {
		Card card = new Card(13, Suits.DIAMONDS);
		Card card2 = new Card(13, Suits.SPADES);
		Card card3 = new Card(13, Suits.HEARTS);
		Card card4 = new Card(7, Suits.DIAMONDS);
		Card card5 = new Card(7, Suits.HEARTS);
		ArrayList<Card> cHand = new ArrayList<Card>();
		cHand.add(card);
		cHand.add(card2);
		cHand.add(card3);
		cHand.add(card4);
		cHand.add(card5);
		eval.handEv(cHand);
		assertEquals(6, eval.getScore());
	}
	
	@Test
	public void fourOfAKind() {
		Card card = new Card(13, Suits.DIAMONDS);
		Card card2 = new Card(13, Suits.CLUBS);
		Card card3 = new Card(13, Suits.HEARTS);
		Card card4 = new Card(13, Suits.SPADES);
		Card card5 = new Card(3, Suits.DIAMONDS);
		ArrayList<Card> cHand = new ArrayList<Card>();
		cHand.add(card);
		cHand.add(card2);
		cHand.add(card3);
		cHand.add(card4);
		cHand.add(card5);
		eval.handEv(cHand);
		assertEquals(7, eval.getScore());
	}
	
	@Test
	public void flush() {
		Card card = new Card(13, Suits.DIAMONDS);
		Card card2 = new Card(2, Suits.DIAMONDS);
		Card card3 = new Card(10, Suits.DIAMONDS);
		Card card4 = new Card(7, Suits.DIAMONDS);
		Card card5 = new Card(3, Suits.DIAMONDS);
		ArrayList<Card> cHand = new ArrayList<Card>();
		cHand.add(card);
		cHand.add(card2);
		cHand.add(card3);
		cHand.add(card4);
		cHand.add(card5);
		eval.handEv(cHand);
		assertEquals(5, eval.getScore());
	}
}
