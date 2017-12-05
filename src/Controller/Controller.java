package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import Model.Card;
import Model.Hand;
import Model.Statistics;
import View.Account;
import View.Table;
import View.VideopokerView;

public class Controller {

	private VideopokerView vpv;
	private Statistics stats;
	private Hand hand;
	private int turn = 0;
	private boolean[] thrownCards = new boolean[5];

	public void init() {
		vpv = new VideopokerView();
		stats = new Statistics();
		hand = new Hand();
		vpv.init();
		vpv.cardOne(new CardOne());
		vpv.cardTwo(new CardTwo());
		vpv.cardThree(new CardThree());
		vpv.cardFour(new CardFour());
		vpv.cardFive(new CardFive());
		vpv.resetGame(new ResetGame());
		vpv.draw(new Draw());
		vpv.account(new AccountListener());
		vpv.setStats(stats.getStats());
	}

	public class AccountListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Account acc = new Account();
			JButton b = (JButton) e.getSource();
			acc.start(b);
			b.setEnabled(false);
			acc.signInListen(new accountSignIn());
			acc.createNewListen(new accountCreateNew());
			acc.addFundsListen(new accountAddFunds());
		}
	}

	class CardOne implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cardButton(e, 0);
		}
	}

	class CardTwo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cardButton(e, 1);
		}
	}

	class CardThree implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cardButton(e, 2);
		}
	}

	class CardFour implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cardButton(e, 3);
		}
	}

	class CardFive implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cardButton(e, 4);
		}
	}

	public void cardButton(ActionEvent e, int i) {

		JButton b = (JButton) e.getSource();
		if (b.getBackground() == Color.RED) {
			b.setBackground(new Color(238, 238, 238));
			b.setText("Hold");
		} else {
			b.setBackground(Color.RED);
			b.setText("Discard");
		}

		this.setThrownCards(i);
	}

	public void setThrownCards(int i) {
		thrownCards[i] = !thrownCards[i];
	}

	class ResetGame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			vpv.startGame();
			for (int i = 0; i < thrownCards.length; i++) {
				thrownCards[i] = false;
			}
			vpv.resetButtons();
			vpv.setStats(stats.getStats());
			turn = 0;
			hand.newHand();
		}
	}

	class Draw implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (turn == 0) {
				Double[] currentStats = stats.getStats();
				ArrayList<Card> startHand = hand.getHand();
				vpv.showCard(startHand);
				vpv.setStats(currentStats);
				turn++;
			} else {
				vpv.resetButtons();
				JButton b = (JButton) e.getSource();
				b.setEnabled(false);
				int[] cardNo = new int[5];
				for (int i = 0; i < thrownCards.length; i++) {
					if (thrownCards[i] == true) {
						cardNo[i] = thrownCards[i] ? 1 : 0;
					}
				}
				hand.discard(cardNo);
				ArrayList<Card> newHand = hand.getHand();
				vpv.showCard(newHand);
				String text = hand.getDrawDesc();
				String description = hand.getDesc();
				vpv.setDescription(description, text);
			}
		}
	}
}

class accountSignIn implements ActionListener {
	public void actionPerformed(ActionEvent e) {

		System.out.println("Stille natt");
	}
}

class accountCreateNew implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("Staffan hade en stalledräng");
	}
}

class accountAddFunds implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("God dag");
	}
}
