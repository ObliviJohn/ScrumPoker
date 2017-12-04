package Model;

import java.io.Serializable;

public class User implements Serializable {
	private int money;
	private String name;
	private String password;
	

	public User() {
		
	}
	public User(int money,  String name, String password) {
		super();
		this.money = money;	
		this.name = name;
		this.password = password;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
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

	@Override
	public String toString() {
		return "User [money=" + money  + ","
				+ " name=" + name + ", password=" + password + "]\n";
	}
	
	
}
