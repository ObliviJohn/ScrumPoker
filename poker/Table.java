package poker;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class Table {

	private Controller controller;
	
	private JFrame frame = new JFrame();
	private Container container = new Container();

	private JPanel table = new JPanel();
	private JPanel details = new JPanel();
		
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
		frame.setVisible(true);
		
	}

	private Component details() {
		Color background = Color.LIGHT_GRAY;
		details.setPreferredSize(new Dimension(400, 400));
		details.setBackground(background);
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