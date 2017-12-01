package poker;

import java.io.Serializable;

import javax.swing.JPasswordField;

public class User2 implements Serializable{
	
	private int money;
	private int id;
	private String name;
	private String password;
	

	public User2() {
		
	}
	public User2(int money, int id, String name, String password) {
		super();
		this.money = money;
		this.id = id;
		this.name = name;
		this.password = password;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public void hidePassword() {
		JPasswordField jpass1 = new JPasswordField();
		jpass1.setEchoChar('*');
	}
	
	public void saveUser() {
		
	}
	
	@Override
	public String toString() {
		return "User [money=" + money + ", id=" + id + ","
				+ " name=" + name + ", password=" + password + "]\n";
	}
	
	public static void main(String[] args) {
		User2 user1 = new User2(20000, 4, "password", "Nisse");
		
		System.out.println(user1.toString());
	}
}
