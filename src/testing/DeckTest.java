package testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
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
import Model.Suits;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DeckTest {

	Deck deck = new Deck();

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
	public void asserNotNull() {
		assertNotNull(deck.cards);
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
}
