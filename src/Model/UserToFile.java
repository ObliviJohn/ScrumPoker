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


public class UserToFile implements Serializable {

	 ArrayList<User> user = new ArrayList<>();

	public  ArrayList<User> getUsers() {
		return user;
	}
	public  void init() {
		try {
			readUser();
			if(user == null) {
				user = new ArrayList<>();
			}
			} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<User> readUser() throws  ClassNotFoundException, IOException {
		List <User> readUser = null;
	
		try{
			
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("userList.txt"));
			readUser = (List<User>) oin.readObject();
	
		
			
		} catch(ClassCastException cc) {
			cc.printStackTrace();
			
		}catch(Exception e) {}
		System.out.println(readUser.toString());
		return readUser;
		
		

	}

}
