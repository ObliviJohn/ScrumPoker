package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class UserToFile implements Serializable {

	ArrayList<User> user = new ArrayList<>();

	public void inputUser(int bank, String name, String password) {

		user.add(new User(bank, name, password));

	}

	public void createUser() {

		try {
			FileOutputStream fos = new FileOutputStream(new File("userList2.txt"), true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(user);
			oos.close();
			fos.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
		System.out.println("Added user");
	}

	public void readUser() throws ClassNotFoundException, IOException {

		File f = new File("userList2.txt");
		FileInputStream fis = new FileInputStream("userList2.txt");
		ObjectInputStream oin = new ObjectInputStream(fis);
		this.user = (ArrayList<User>) oin.readObject();

		try {

			if (f.exists()) {
				User u = new User();
				this.user.add(u);
			}

		} catch (ClassCastException cc) {
			cc.printStackTrace();

		}

		for (User u : user) {
			System.out.println(u);
		}
		System.out.println(oin.toString());

	}

}
