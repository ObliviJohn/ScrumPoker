package Model;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class UserToFileOld implements Serializable {

	 ArrayList<User> user = new ArrayList<>();

	public  ArrayList<User> getUsers() {
		return user;
	}
	public  void init() {
		try {
			user = readUser();
			if(user == null) {
				user = new ArrayList<>();
			}
			} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void inputUser(int bank,  String name ,String password) {

		user.add(new User(bank,name,password));
		
	}
	public  void createUser() {
		
	
		
		try {
		FileOutputStream fos = new FileOutputStream(new File("userList.txt"));
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
	public  ArrayList<User> readUser() throws  ClassNotFoundException, IOException {
		ArrayList <User> readUser = null;
	
		try{
			
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("userList.txt"));
			readUser = (ArrayList<User>) oin.readObject();
	
		
			
		} catch(ClassCastException cc) {
			cc.printStackTrace();
			
		}catch(Exception e) {}
//		System.out.println(readUser.toString());
		return readUser;
		
		
	}


	
}
