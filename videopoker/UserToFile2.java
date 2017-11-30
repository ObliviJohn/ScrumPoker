package videopoker;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserToFile {
	ArrayList<User> user = new ArrayList<>();
	
	
	private void inputUser() {
		user.add(new User(2,2,"nisse","ness"));
		user.add(new User(2,2,"nisse","ness"));
		user.add(new User(2,2,"nisse","ness"));
		
	}
	public void createUser() {
		
		File f = new File("usesrList.obj");
		
		try {
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(user);
		oos.close();
		fos.close();
		}catch (IOException i ) {
			i.printStackTrace();
		}
				System.out.println("Added user");
	}
	
	@SuppressWarnings("unchecked")
	public void readUser() throws  ClassNotFoundException, IOException {
	

		FileInputStream fis = new FileInputStream("userList.obj");
		ObjectInputStream oin = new ObjectInputStream(fis);
		ArrayList<User> user2 = new ArrayList<User>();
		try{
			while(true) {
				User u = (User)oin.readObject();
				user2.add(u);
			}
		
		
		} catch(EOFException ex ) {
		}catch(ClassCastException cc) {
			cc.printStackTrace();
			
		}
		
		for(User u : user2) {
			System.out.println(u);
		}
		
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		UserToFile utf = new UserToFile();
		
		System.out.println(utf.user.toString());
	}

	
}

