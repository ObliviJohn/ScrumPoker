package poker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	private Table table;
	private VideopokerView videoPokerView;

	public void init() {
		// table = new Table(this);
		// table.showTable();
		// table.account(new accountListener());
		videoPokerView = new VideopokerView();
		videoPokerView.init();
		videoPokerView.cardOne(new cardOne());
		videoPokerView.cardTwo(new cardTwo());
		videoPokerView.cardThree(new cardThree());
		videoPokerView.cardFour(new cardFour());
		videoPokerView.cardFive(new cardFive());
		videoPokerView.draw(new draw());
	}
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
		System.out.println("Draw");
	}
}