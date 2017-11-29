package poker;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.border.Border;

public class VideopokerView {

	private JFrame frame = new JFrame();
	private Container container = new Container();

	private JButton cardOne = new JButton();
	private JButton cardTwo = new JButton();
	private JButton cardThree = new JButton();
	private JButton cardFour = new JButton();
	private JButton cardFive = new JButton();
	private JButton draw = new JButton();
	private JLabel info;
	public void init() {
		frame.setPreferredSize(new Dimension(1280, 720));
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
		String[] hands = { "High card: " , "Pair: " , "Two pairs: " , "Three of a kind: " , "Straight: " ,
						  "Flush: ", "Full house: " , "Four of a kind: " , "Straight Flush: " , "Royal Flush: " , };

		panel.setLayout(new GridLayout(3,8));
		
		for ( int i = 0; i < 24; i++) {
			info = new JLabel();
			info.setSize(new Dimension(150, 30));
			switch(i) {
			case 0:
				info.setText(hands[0]);
				break;
			case 2:
				info.setText(hands[3]);
				break;
			case 4:
				info.setText(hands[6]);
				break;
			case 6:
				info.setText(hands[9]);
				break;
			case 8:
				info.setText(hands[1]);
				break;
			case 10:
				info.setText(hands[4]);
				break;
			case 12:
				info.setText(hands[7]);
				break;
			case 14:
				info.setText("Players name");
				break;
			case 16:
				info.setText(hands[2]);
				break;
			case 18:
				info.setText(hands[5]);
				break;
			case 20:
				info.setText(hands[8]);
				break;
			case 15: case 22: case 23:
				info.setText("");
				break;
			default:
				info.setText("0 %");
				break;
			}
			panel.add(info);
		}
		return panel;
	}

	private Component topLevel() {
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		Color background = Color.decode("#076324");

		JPanel panel = new JPanel();
		panel.setBackground(background);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		for (int i = 1; i < 6; i++) {
			gbc.gridy = 0;
			gbc.gridx = i;
			gbc.insets = new Insets(0, 10, 0, 0);
			JLabel card = new JLabel();
			card.setPreferredSize(new Dimension(100, 145));
			card.setBorder(border);
			card.setText("Card " + i);
			panel.add(card, gbc);
		}

		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.insets = new Insets(10, 10, 0, 0);
		cardOne.setPreferredSize(new Dimension(50, 20));
		cardOne.setText("Discard");
		panel.add(cardOne, gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 2;
		gbc.insets = new Insets(10,10,0,0);
	    cardTwo.setPreferredSize(new Dimension(50, 20));
	    cardTwo.setText("Discard");
	    panel.add(cardTwo, gbc);
	    
		gbc.gridy = 1;
		gbc.gridx = 3;
		gbc.insets = new Insets(10,10,0,0);
	    cardThree.setPreferredSize(new Dimension(50, 20));
	    cardThree.setText("Discard");
	    panel.add(cardThree, gbc);
	    
		gbc.gridy = 1;
		gbc.gridx = 4;
		gbc.insets = new Insets(10,10,0,0);
	    cardFour.setPreferredSize(new Dimension(50, 20));
	    cardFour.setText("Discard");
	    panel.add(cardFour, gbc);
	    
		gbc.gridy = 1;
		gbc.gridx = 5;
		gbc.insets = new Insets(10,10,0,0);
	    cardFive.setPreferredSize(new Dimension(50, 20));
	    cardFive.setText("Discard");
	    panel.add(cardFive, gbc);
	    
		gbc.gridy = 1;
		gbc.gridx = 6;
		gbc.insets = new Insets(10,100,0,0);
	    draw.setPreferredSize(new Dimension(50, 20));
	    draw.setText("Discard");
	    panel.add(draw, gbc);

		panel.setPreferredSize(new Dimension(1280, 360));
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
}