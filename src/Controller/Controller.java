package Controller;

import java.awt.Color;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.Card;
import Model.Hand;
import Model.Statistics;
import Model.User;
import Model.UserToFile;
import View.Account;
import View.Table;
import View.VideopokerView;

public class Controller {
private boolean[] thrownCards = new boolean[5];
	
	private Table table;
	private VideopokerView vpv;
	private Statistics stats;
	private Account acc;
	private User user;
	private UserToFile utf = new UserToFile();
//	Starting odds before drawing any cards
	private Double[] odds = { 42.3, 4.8, 2.1, 0.39, 0.20, 0.14, 0.024, 0.0014, 0.00015 };
	private Hand hand;
	private int turn = 0;

	public void init() {
		vpv = new VideopokerView();
		stats = new Statistics();
		hand = new Hand();
		vpv.init();
		
		user = new User(50, "Guest", "password");
		
		vpv.cardOne(new CardOne());
		vpv.cardTwo(new CardTwo());
		vpv.cardThree(new CardThree());
		vpv.cardFour(new CardFour());
		vpv.cardFive(new CardFive());
		vpv.resetGame(new ResetGame());
		vpv.draw(new Draw());
		vpv.account(new AccountListener());
		vpv.setStats(stats.getStats(hand.getVal(),hand.getDrawVal()));

		utf.init();
		System.out.println(utf.getUsers());
	}

	public class AccountListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			acc = new Account();
			JButton b = (JButton) e.getSource();
			acc.start(b);
			b.setEnabled(false);
			acc.signInListen(new accountLogIn());
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
			
			vpv.setStats(stats.getStats(0, 0));
			turn = 0;
			
			hand.newHand();
		}
	}

	class Draw implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (turn == 0) {
				Double[] currentStats = stats.getStats(hand.getVal(), hand.getDrawVal());
				ArrayList<Card> startHand = hand.getHand();
				vpv.showCard(startHand);
				vpv.setStats(currentStats);
				String text = hand.getDrawDesc();
				String description = hand.getDesc();
				vpv.setDescription(description, text);
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
				String description = hand.getDesc();
				vpv.setDescription(description, "");
			}
		}
	}

	class accountLogIn implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String accName = acc.getUsernameField();
			String accPass = acc.getPasswordField();

			for(User u : utf.getUsers()) {
				if(u.getName().equals(accName) && u.getPassword().equals(accPass) ) {
					user = u;
					updateUser(user.getName(), user.getMoney());
					return;
			}
			}
			JOptionPane.showMessageDialog(null, "Login Failed!!!");
	}

	}


	class accountCreateNew implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String accName = acc.getUsernameField();
			String accPass = acc.getPasswordField();
			int funds = acc.getFundsField();
			
			for(User u : utf.getUsers()) {
				if(u.getName().equals(accName)) {
					JOptionPane.showMessageDialog(null, "Username already exists!!!");
					return;
				}
			}
			utf.inputUser(funds, accName, accPass);
			user = new User(funds, accName, accPass);
			utf.createUser();
			updateUser(user.getName(), user.getMoney());
		}
	}

	class accountAddFunds implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			user.setMoney(user.getMoney() + acc.getFundsField());
			utf.createUser();
			updateUser(user.getName(), user.getMoney());
		}
	}
	
	
	public void updateUser(String name, int funds) {
		acc.setUsername(acc.getUsernameField());
		vpv.setUsername(name, funds);
		System.out.println(user);
	}
	
}

