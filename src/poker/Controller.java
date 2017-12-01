package poker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller {

	private Table table;
	private VideopokerView vpv;
	private Account acc;

	// Just an array for testing setting stats
	private int[] testStats = new int[10];

	public void init() {
		// table = new Table(this);
		// table.showTable();
		vpv = new VideopokerView();
		vpv.init();
		vpv.cardOne(new cardOne());
		vpv.cardTwo(new cardTwo());
		vpv.cardThree(new cardThree());
		vpv.cardFour(new cardFour());
		vpv.cardFive(new cardFive());
		vpv.draw(new draw());
		vpv.account(new accountListener());
		

	}

	class accountListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			acc = new Account();
			JButton b = (JButton)e.getSource();
			acc.start(b);
			b.setEnabled(false);
			

			acc.signInListen(new accountSignIn());
			acc.createNewListen(new accountCreateNew());
			acc.addFundsListen(new accountAddFunds());
		}
	}

	class cardOne implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getBackground() == Color.RED) {
				b.setBackground(new Color(238,238,238));
			} else {
				b.setBackground(Color.RED);
			}
		}
	}

	class cardTwo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getBackground() == Color.RED) {
				b.setBackground(new Color(238,238,238));
			} else {
				b.setBackground(Color.RED);
			}
		}
	}

	class cardThree implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getBackground() == Color.RED) {
				b.setBackground(new Color(238,238,238));
			} else {
				b.setBackground(Color.RED);
			}
		}
	}

	class cardFour implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getBackground() == Color.RED) {
				b.setBackground(new Color(238,238,238));
			} else {
				b.setBackground(Color.RED);
			}
		}
	}

	class cardFive implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getBackground() == Color.RED) {
				b.setBackground(new Color(238,238,238));
			} else {
				b.setBackground(Color.RED);
			}
		}
	}

	class draw implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < testStats.length; i++) {
				testStats[i] = 10;
			}
			vpv.setStats(testStats);
		}
	}
	class accountSignIn implements ActionListener {
		public void actionPerformed(ActionEvent e) {

System.out.println(acc.getUsernameField());
		}
	}
	class accountCreateNew implements ActionListener {
		public void actionPerformed(ActionEvent e) {
System.out.println(acc.getPasswordField());
		}
	}
	class accountAddFunds implements ActionListener {
		public void actionPerformed(ActionEvent e) {
System.out.println(acc.getFundsField());
		}
	}





}