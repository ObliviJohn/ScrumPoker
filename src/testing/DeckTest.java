package testing;

import java.util.ArrayList;
import java.util.List;

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
	
	@Rule
	public TestRule testWatcher = new TestWatcher() {
		
		@Override
		public Statement apply( Statement base, Description description ) {
			return super.apply( base, description );
		}
		
		@Override
		protected void succeeded( Description description ) {
			System.out.println("Test " + description.getDisplayName() + " passed.");
		}
		
		@Override
		protected void failed( Throwable e, Description description ) {
			System.out.println("Test " + description.getDisplayName() + " failed.");
		}
		
		@Override
		protected void skipped( AssumptionViolatedException e, Description description ) {
			System.out.println("Test " + description.getDisplayName() + " skipped.");
		}
		
		@Override
		protected void starting( Description description ) {
			super.starting(description);
			System.out.println("Test " + description.getDisplayName() + " Started.");
		}
		
		@Override 
		protected void finished( Description description ) {
			super.finished(description);
			System.out.println("Test " + description.getDisplayName() + " finished.\n");
		}
	};
	
	@Test
	public void deckHas52Cards() {
		Deck deck = new Deck();
		assert 52 == deck.cards.size();
	}
	
	@Test
	public void duplicateCard() {
		Deck deck = new Deck();
		Card card = new Card(2, Suits.HEARTS);
		System.out.println(card);
		System.out.println(deck.cards.get(1));
		if ( card != deck.cards.get(2)) {
			System.out.println("Card found");
		}

//		
		
		
	}
}
