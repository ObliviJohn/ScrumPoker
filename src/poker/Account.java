package poker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Account {
	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();

	
	private JTextField login = new JTextField("Usernamn");
	private JPasswordField password = new JPasswordField("Password");
	private JTextField funds = new JTextField("0.00");
	private JLabel curUser = new JLabel("Current User: Guest");


	private JButton signInButt = new JButton("Login");
	private JButton createNewButt = new JButton("Create New");
	private JButton addFundsButt = new JButton("Add funds");
	
	public void start(JButton j) {
		frame.setPreferredSize(new Dimension(500, 700));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	j.setEnabled(true);
		    }
		});
		
		Color background = new Color(225,225,225);
		Font font = new Font("Verdana", Font.BOLD, 25);


		GridBagConstraints gbc = new GridBagConstraints();
		panel.setBackground(background);
		panel.setLayout(new GridBagLayout());
		

		JLabel text = new JLabel("User settings");
		text.setFont(font);
		text.setPreferredSize(new Dimension(200, 60));
		gbc.insets = new Insets(00,0,100,0);
		gbc.gridy = 0;
		gbc.gridx = 1;
		panel.add(text, gbc);
		

		gbc.insets = new Insets(00,00,00,00);
		login.setPreferredSize(new Dimension(200, 30));
		gbc.gridx = 1;
		gbc.gridy ++;
		panel.add(login, gbc);
		
		password.setPreferredSize(new Dimension(200, 30));
		gbc.gridy ++;
		gbc.gridx = 1;
		panel.add(password, gbc);
		
		System.out.println(panel.getComponentCount());
		curUser.setPreferredSize(new Dimension(200, 30));
		gbc.insets = new Insets(00,80,0,0);
		gbc.gridy ++;
		gbc.gridx = 1;
		panel.add(curUser, gbc);
		

		gbc.gridx = 1;
		gbc.gridy ++;
		gbc.insets = new Insets(00,0,0,100);
		signInButt.setPreferredSize(new Dimension(100, 30));
		panel.add(signInButt, gbc);

		gbc.insets = new Insets(0,100,0,0);
		createNewButt.setPreferredSize(new Dimension(100, 30));
		panel.add(createNewButt, gbc);

		gbc.gridx = 1;
		gbc.gridy ++;
		gbc.insets = new Insets(100,0,00,100);
		funds.setPreferredSize(new Dimension(100, 30));
		panel.add(funds, gbc);

		gbc.gridx = 1;
		gbc.insets = new Insets(100,100,00,0);
		addFundsButt.setPreferredSize(new Dimension(100, 30));
		panel.add(addFundsButt, gbc);
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	

	public void signInListen(ActionListener act) {
		signInButt.addActionListener(act);
	}
	public void createNewListen(ActionListener act) {
		createNewButt.addActionListener(act);
	}
	public void addFundsListen(ActionListener act) {
		addFundsButt.addActionListener(act);
	}
	public void setUsername(String username) {
		curUser = new JLabel("Current User: "+username);
	}
	public String getUsernameField() {
		return login.getText();
	}
	public String getPasswordField() {
		char[] arr= password.getPassword();
		String retStr = new String(arr);
		
		
		return retStr;
	}
	public String getFundsField() {
		return funds.getText();
	}

}