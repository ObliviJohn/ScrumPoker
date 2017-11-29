package poker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller {

	private Table table;
	private VideopokerView vpv;
	
//	Just an array for testing setting stats
	private int[] testStats = new int[10];

	public void init() {
		// table = new Table(this);
		// table.showTable();
		// table.account(new accountListener());
		vpv = new VideopokerView();
		vpv.init();
		vpv.cardOne(new cardOne());
		vpv.cardTwo(new cardTwo());
		vpv.cardThree(new cardThree());
		vpv.cardFour(new cardFour());
		vpv.cardFive(new cardFive());
		vpv.draw(new draw());
	}

	class accountListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Account acc = new Account();
			acc.start();
		}
	}

	class cardOne implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Card 1");

			JButton b = (JButton) e.getSource();
			
			System.out.println(b.getBackground());
			b.setBackground(new Color(238, 238, 238));
			b.setBorderPainted(false);
//			b.setOpaque(!b.isOpaque());
		}
	}

	class cardTwo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Card 2");
		}
	}

	class cardThree implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Card 3");
		}
	}

	class cardFour implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Card 4");

		}
	}

	class cardFive implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Card 5");
		}
	}

	class draw implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for ( int i = 0; i < testStats.length; i++) {
				testStats[i] = 10;
			}
			vpv.setStats(testStats);
		}
	}
}