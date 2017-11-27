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
	
	private JLabel welcome = new JLabel("POKER GAME");
	
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
		
		Border blackline = BorderFactory.createLineBorder(Color.BLACK);
		
		JPanel leftPlayer = new JPanel();
		JPanel topPlayer = new JPanel();
		JPanel rightPlayer = new JPanel();
		JPanel bottomPlayer = new JPanel();
		
		leftPlayer.setBorder(blackline);
		rightPlayer.setBorder(blackline);
		topPlayer.setBorder(blackline);
		bottomPlayer.setBorder(blackline);
		
		leftPlayer.setPreferredSize(new Dimension(100,600));
		rightPlayer.setPreferredSize(new Dimension(100,600));
		topPlayer.setPreferredSize(new Dimension(400,100));
		bottomPlayer.setPreferredSize(new Dimension(800,100));		
		
		Color background = Color.decode("#076324");
		
		table.setLayout(new BorderLayout());
		table.add(rightPlayer, BorderLayout.EAST);
		table.add(topPlayer, BorderLayout.PAGE_START);
		table.add(leftPlayer, BorderLayout.WEST);
		table.add(bottomPlayer, BorderLayout.PAGE_END);
		
		table.add(welcome, BorderLayout.CENTER);
		
		table.setPreferredSize(new Dimension(1400,900));
		table.setBackground(background);
		
		return table;
	}

}
