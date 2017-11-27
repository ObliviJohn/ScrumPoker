package poker;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Table {

	private Controller controller;
	
	private JFrame frame = new JFrame();
	private Container container = new Container();

	private JPanel table = new JPanel();
	private JPanel details = new JPanel();
	
	private JLabel welcome = new JLabel("WELCOME TO");
	private JLabel poker = new JLabel("ALEX POKER GAME");
	
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
		table.add(sidePlayer(), BorderLayout.EAST);
		table.add(horizontalPlayer(), BorderLayout.PAGE_START);
		table.add(sidePlayer(), BorderLayout.WEST);
		table.add(horizontalPlayer(), BorderLayout.PAGE_END);
		table.add(center(), BorderLayout.CENTER);
				
		table.setPreferredSize(new Dimension(1400,900));
		
		return table;
	}

	private Component horizontalPlayer() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(400,100));
		Color background = Color.decode("#076324");
		panel.setBackground(background);
		return panel;
	}

	private Component sidePlayer() {
		JPanel panel = new JPanel();
		Color background = Color.decode("#076324");
		panel.setPreferredSize(new Dimension(100, 600));
		panel.setBackground(background);
		return panel;
	}

	private JComponent center() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		Font f = new Font("serif", Font.BOLD, 54);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 1;
		welcome.setFont(f);
		panel.add(welcome, gbc);
		
		gbc.gridx = 5;
		gbc.gridy = 2;
		poker.setFont(f);
		
		panel.add(poker, gbc);
		panel.setBackground(Color.decode("#076324"));
		return panel;
	}
}