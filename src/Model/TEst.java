package Model;

import java.io.IOException;

public class TEst {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		UserToFile tust = new UserToFile();
		tust.inputUser(123, "jhjh", "hebetrippin");
		tust.createUser();
		tust.readUser();
	}

}
