package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.Statistics;
import Model.User;
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
//	Starting odds before drawing any cards
	private Double[] odds = { 42.3, 4.8, 2.1, 0.39, 0.20, 0.14, 0.024, 0.0014, 0.00015 };

	public void init() {
		// table = new Table(this);
		// table.showTable();
		vpv = new VideopokerView();
		stats = new Statistics();
		vpv.init();
		vpv.cardOne(new cardOne());
		vpv.cardTwo(new cardTwo());
		vpv.cardThree(new cardThree());
		vpv.cardFour(new cardFour());
		vpv.cardFive(new cardFive());
		vpv.draw(new draw());
		vpv.account(new accountListener());
		vpv.setStats(odds);
	
		user = new User(50, "Guest", "password");
	}

	public class accountListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			acc = new Account();
			JButton b = (JButton) e.getSource();
			acc.start(b);
			b.setEnabled(false);

			acc.signInListen(new accountSignIn());
			acc.createNewListen(new accountCreateNew());
			acc.addFundsListen(new accountAddFunds());
		}
	}

	class cardOne implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cardButton(e);
		}
	}

	class cardTwo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cardButton(e);
		}
	}

	class cardThree implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cardButton(e);
		}
	}

	class cardFour implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cardButton(e);
		}
	}

	class cardFive implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cardButton(e);
		}
	}

	public void cardButton(ActionEvent e) {

		JButton b = (JButton) e.getSource();

		if (b.getBackground() == Color.RED) {
			b.setBackground(new Color(238, 238, 238));
			b.setText("Hold");
		} else {
			b.setBackground(Color.RED);
			b.setText("Discard");
		}
	
		
	}

	class draw implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			vpv.setStats(stats.getStats());
//			Just for trying too see if the stats are changing
			for ( int i = 0; i < stats.getStats().length; i++ ) {
				System.out.println("Controller: " + stats.getStats()[i]);
			}
			for(int i = 0 ; i < 5 ; i++) {
				
				System.out.println(thrownCards[i]);
				
			}
		}
	}

	class accountSignIn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			user = new User(50, acc.getUsernameField(), acc.getPasswordField());

			updateUser(acc.getUsernameField(), acc.getFundsField());
		}
	}

	class accountCreateNew implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			user = new User(50, acc.getUsernameField(), acc.getPasswordField());
			updateUser(acc.getUsernameField(), acc.getFundsField());
		}
	}

	class accountAddFunds implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			user.setMoney(user.getMoney() + acc.getFundsField());
			System.out.println(user);
		}
	}

	public void updateUser(String name, int funds) {
		acc.setUsername(acc.getUsernameField());
		vpv.setUsername(name, funds);
		System.out.println(user);
	}
	
}