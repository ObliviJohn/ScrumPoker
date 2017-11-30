package poker;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class Account {
	
	private JFrame frame = new JFrame();
	private Container container;
	
	public void start() {
		frame.setPreferredSize(new Dimension(500, 700));
		
		container = frame.getContentPane();
		container.setLayout(new GridBagLayout());
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}