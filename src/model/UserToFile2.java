package model;

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

public class UserToFile2 {
	ArrayList<User2> user = new ArrayList<>();
	
	
	private void inputUser() {
		user.add(new User2(2,2,"nisse","ness"));
		user.add(new User2(2,2,"nisse","ness"));
		user.add(new User2(2,2,"nisse","ness"));
		
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
		ArrayList<User2> user2 = new ArrayList<User2>();
		try{
			while(true) {
				User2 u = (User2)oin.readObject();
				user2.add(u);
			}
		
		
		} catch(EOFException ex ) {
		}catch(ClassCastException cc) {
			cc.printStackTrace();
			
		}
		
		for(User2 u : user2) {
			System.out.println(u);
		}
		
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		UserToFile2 utf = new UserToFile2();
		
		System.out.println(utf.user.toString());
	}

	
}

