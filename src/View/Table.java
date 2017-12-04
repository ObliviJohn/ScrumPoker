package View;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.Controller;

public class Table {

	private Controller controller;
	
	private JFrame frame = new JFrame();
	private Container container = new Container();

	private JPanel table = new JPanel();
	private JPanel details;
	
	private	JButton account = new JButton("Account");
		
	public Table(Controller controller) {
		this.controller = controller;
	}
	
	public void showTable() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2 - frame.getSize().width/2, dim.height/2 - frame.getSize().height/2);
		
		container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		
		container.add(gameTable(), BorderLayout.WEST);
		container.add(details(), BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

	public void account(ActionListener act) {
		account.addActionListener(act);
	}
	
	private Component details() {
		details = new JPanel(new SpringLayout());
		Color background = Color.LIGHT_GRAY;
		JLabel cardsPlayed = new JLabel("Cards played:");
		JLabel cardsRemaining = new JLabel("Cards left in deck:");
		JLabel cardsPlayedNumber = new JLabel("13");
		JLabel cardsRemainingNumber = new JLabel("39");
		JLabel possibilityForAce = new JLabel("Possibility for Ace: ");
		JLabel percentageForAce = new JLabel("7.69%");
		JLabel possibilityForPair = new JLabel("Possibility for Pair: ");
		JLabel percentageForPair = new JLabel("100%");
		JLabel possibilityForTwoPairs = new JLabel("Possibility for Two pairs: ");
		JLabel percentageForTwoPairs = new JLabel("88%");
		JLabel possibilityForRoyalStraightFlush = new JLabel("Possibility for Royal Straight Flush: ");
		JLabel percentageForRoyalStraightFlush = new JLabel("0%");
		JLabel possibilityForDeadMansHand = new JLabel("Possibility for Dead Mans Hand: ");
		JLabel percentageForDeadMansHand = new JLabel("72%");
		JLabel possibilityForStraight = new JLabel("Possibility for a Straight: ");
		JLabel percentageForStraight = new JLabel("45%");
		JLabel possibilityForTrice = new JLabel("Possibility for Three of a kind: ");
		JLabel percentageForTrice = new JLabel("90%");
		JLabel possibilityForQuartal = new JLabel("Possibility for Four of a kind: ");
		JLabel percentageForQuartal = new JLabel("10%");
		JLabel possibilityForThreePairs = new JLabel("Possibility for Three pairs: ");
		JLabel percentageForThreePairs = new JLabel("48%");
		JLabel pot = new JLabel("Pot: $5");
		JTextField amount = new JTextField();
		
		
		JButton bet = new JButton("Bet");
		JButton stand = new JButton("Stand");
		JButton allIn = new JButton("All In");
		
		Font font = new Font("serif", Font.BOLD, 24);
		cardsPlayed.setFont(font);
		cardsRemaining.setFont(font);
		cardsPlayedNumber.setFont(font);
		cardsRemainingNumber.setFont(font);
		possibilityForAce.setFont(font);
		percentageForAce.setFont(font);
		possibilityForPair.setFont(font);
		percentageForPair.setFont(font);
		possibilityForTwoPairs.setFont(font);
		percentageForTwoPairs.setFont(font);
		possibilityForThreePairs.setFont(font);
		percentageForThreePairs.setFont(font);
		possibilityForStraight.setFont(font);
		percentageForStraight.setFont(font);
		possibilityForTrice.setFont(font);
		percentageForTrice.setFont(font);
		possibilityForQuartal.setFont(font);
		percentageForQuartal.setFont(font);
		possibilityForDeadMansHand.setFont(font);
		percentageForDeadMansHand.setFont(font);
		possibilityForRoyalStraightFlush.setFont(font);
		percentageForRoyalStraightFlush.setFont(font);
		pot.setFont(font);
		
		details.add(cardsPlayed);
		details.add(cardsPlayedNumber);
		details.add(cardsRemaining);
		details.add(cardsRemainingNumber);
		details.add(possibilityForAce);
		details.add(percentageForAce);
		details.add(possibilityForPair);
		details.add(percentageForPair);
		details.add(possibilityForTwoPairs);
		details.add(percentageForTwoPairs);
		details.add(possibilityForThreePairs);
		details.add(percentageForThreePairs);
		details.add(possibilityForQuartal);
		details.add(percentageForQuartal);
		details.add(possibilityForStraight);
		details.add(percentageForStraight);
		details.add(possibilityForTrice);
		details.add(percentageForTrice);
		details.add(possibilityForDeadMansHand);
		details.add(percentageForDeadMansHand);
		details.add(possibilityForRoyalStraightFlush);
		details.add(percentageForRoyalStraightFlush);

		details.add(bet);
		details.add(amount);
		
		details.add(allIn);
		details.add(stand);
		
		details.add(pot);
		details.add(account);

		details.setPreferredSize(new Dimension(500, 200));
		details.setBackground(background);
		SpringUtilities.makeCompactGrid(details, 14, 2, 2, 2, 3, 35);
		details.setOpaque(true);
		return details;
	}

	private JPanel gameTable() {		
		table.setLayout(new BorderLayout());
		table.add(hiddenPlayer(), BorderLayout.EAST);
		table.add(horizontalPlayer(), BorderLayout.PAGE_START);
		table.add(hiddenPlayer(), BorderLayout.WEST);
		table.add(hiddenPlayer(), BorderLayout.PAGE_END);
		table.add(center(), BorderLayout.CENTER);
				
		table.setPreferredSize(new Dimension(1400,900));
		
		return table;
	}

	private Component horizontalPlayer() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JLabel card1 = new JLabel();
		JLabel card2 = new JLabel();
		ImageIcon img = new ImageIcon("src/poker/Resources/10S.png");
		ImageIcon img2 = new ImageIcon("src/poker/Resources/8C.png");

		card1.setIcon(img);
		card2.setIcon(img2);

		panel.add(card1);
		panel.add(card2);
		panel.setPreferredSize(new Dimension(400,100));
		Color background = Color.decode("#076324");
		panel.setBackground(background);

		return panel;
	}

	private Component hiddenPlayer() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JLabel card1 = new JLabel();
		JLabel card2 = new JLabel();
		ImageIcon img = new ImageIcon("src/poker/Resources/Backside.png");
		card1.setIcon(img);
		card2.setIcon(img);
		panel.add(card1);
		panel.add(card2);
		panel.setPreferredSize(new Dimension(400,100));
		Color background = Color.decode("#076324");
		panel.setBackground(background);

		return panel;
	}

	private JComponent center() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		JLabel card1 = new JLabel();
		JLabel card2 = new JLabel();
		JLabel card3 = new JLabel();
		JLabel card4 = new JLabel();
		JLabel card5 = new JLabel();
		
		JLabel welcome = new JLabel("WELCOME TO ALEX POKER GAME");
		
		ImageIcon img = new ImageIcon("src/poker/Resources/8S.png");
		card1.setIcon(img);	
		ImageIcon img2 = new ImageIcon("src/poker/Resources/AC.png");
		card2.setIcon(img2);
		ImageIcon img3 = new ImageIcon("src/poker/Resources/Backside.png");
		card3.setIcon(img3);
		card4.setIcon(img3);
		card5.setIcon(img3);
				
		GridBagConstraints gbc = new GridBagConstraints();
		Font font = new Font("serif", Font.ITALIC, 30 );
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets= new Insets(0,10,10,10);
		panel.add(card1, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(card2, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		panel.add(card3, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		panel.add(card4, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 0;
		panel.add(card5, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 5;
		welcome.setFont(font);
		panel.add(welcome, gbc);
		
		panel.setBackground(Color.decode("#076324"));
		return panel;
	}
}