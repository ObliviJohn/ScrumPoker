package poker;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import poker.Controller.accountListener;

public class VideopokerView {

	private JFrame frame = new JFrame();
	private Container container = new Container();

	private JButton cardOne = new JButton();
	private JButton cardTwo = new JButton();
	private JButton cardThree = new JButton();
	private JButton cardFour = new JButton();
	private JButton cardFive = new JButton();
	private JButton account = new JButton("Account");
	private JButton draw = new JButton();
	private JLabel[] info = new JLabel[24];
	private JLabel[] cards = new JLabel[5];
	
	public void init() {
		frame.setPreferredSize(new Dimension(1000, 620));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

		container = frame.getContentPane();
		frame.setResizable(false);
		container.setLayout(new GridLayout(2, 1));
		container.add(topLevel());
		container.add(stats());
		
	}

	private Component stats() {
		JPanel panel = new JPanel();
		String[] hands = { "Pair: " , "Two pairs: " , "Three of a kind: " , "Straight: " ,
						  "Flush: ", "Full house: " , "Four of a kind: " , "Straight Flush: " , "Royal Flush: "};

		panel.setLayout(new GridLayout(3,8));
		
		for ( int i = 0; i < 24; i++) {
			info[i] = new JLabel();
			info[i].setSize(new Dimension(150, 30));
			switch(i) {
			case 0:
				info[i].setText(hands[0]);
				break;
			case 2:
				info[i].setText(hands[3]);
				break;
			case 4:
				info[i].setText(hands[6]);
				break;
			case 6:
				info[i].setText("Players name");
				break;
			case 8:
				info[i].setText(hands[1]);
				break;
			case 10:
				info[i].setText(hands[4]);
				break;
			case 12:
				info[i].setText(hands[7]);
				break;
			case 14:

				break;
			case 16:
				info[i].setText(hands[2]);
				break;
			case 18:
				info[i].setText(hands[5]);
				break;
			case 20:
				info[i].setText(hands[8]);
				break;
			case 15: case 22: case 23:
				info[i].setText("");
				break;
			default:
				info[i].setText("");
				break;
			}
			panel.add(info[i]);
		}
		return panel;
	}
	
	public void setStats(Double[] odds) {
		int pos = 1;
		for ( int i = 0; i < odds.length; i++ ) {
			info[pos].setText(odds[i] + "%");
			pos += 2;
			if ( pos == 7 ) {
				pos += 2;
			}
			if ( pos == 15 ) {
				pos += 2;
			}
		}
	}

	private Component topLevel() {
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		Color background = Color.decode("#076324");

		JPanel panel = new JPanel();
		panel.setBackground(background);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		for (int i = 0; i < 5; i++) {
			gbc.gridy = 0;
			gbc.gridx = i + 1;
			gbc.insets = new Insets(0, 10, 0, 0);
			cards[i] = new JLabel();
			cards[i].setPreferredSize(new Dimension(100, 145));
			cards[i].setBorder(border);
			cards[i].setText("Card " + i);
			panel.add(cards[i], gbc);
		}

		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.insets = new Insets(10, 10, 0, 0);
		cardOne.setPreferredSize(new Dimension(100, 30));
		cardOne.setText("Hold");
		panel.add(cardOne, gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 2;
		gbc.insets = new Insets(10,10,0,0);
	    cardTwo.setPreferredSize(new Dimension(100, 30));
	    cardTwo.setText("Hold");
	    panel.add(cardTwo, gbc);
	    
		gbc.gridy = 1;
		gbc.gridx = 3;
		gbc.insets = new Insets(10,10,0,0);
	    cardThree.setPreferredSize(new Dimension(100, 30));
	    cardThree.setText("Hold");
	    panel.add(cardThree, gbc);
	    
		gbc.gridy = 1;
		gbc.gridx = 4;
		gbc.insets = new Insets(10,10,0,0);
	    cardFour.setPreferredSize(new Dimension(100, 30));
	    cardFour.setText("Hold");
	    panel.add(cardFour, gbc);
	    
		gbc.gridy = 1;
		gbc.gridx = 5;
		gbc.insets = new Insets(10,10,0,0);
	    cardFive.setPreferredSize(new Dimension(100, 30));
	    cardFive.setText("Hold");
	    panel.add(cardFive, gbc);
	    
		gbc.gridy = 1;
		gbc.gridx = 10;
		gbc.insets = new Insets(10,90,0,0);
	    draw.setPreferredSize(new Dimension(100, 30));
	    draw.setText("Draw");
	    panel.add(draw, gbc);
	    
	    gbc.gridy = 3;
	    gbc.gridx = 14;
	    account.setPreferredSize(new Dimension(100, 40));
	    panel.add(account, gbc);

		return panel;
	}
	
	public void cardOne(ActionListener act) {
		cardOne.addActionListener(act);
	}
	
	public void cardTwo(ActionListener act) {
		cardTwo.addActionListener(act);
	}
	
	public void cardThree(ActionListener act) {
		cardThree.addActionListener(act);
	}
	
	public void cardFour(ActionListener act) {
		cardFour.addActionListener(act);
	}
	
	public void cardFive(ActionListener act) {
		cardFive.addActionListener(act);
	}
	
	public void draw(ActionListener act) {
		draw.addActionListener(act);
	}

	public void account(ActionListener act) {
		account.addActionListener(act);
	}
}