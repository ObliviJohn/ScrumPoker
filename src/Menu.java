import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<User> userList;

    public void menu(){
        //Skapa Testanvändare
        userList.add(new User(1,"Alpha","Beta"));

        String userInput;
        Scanner scInput = new Scanner(System.in);
        while (true){
            printMenuOptions();
            //Valideriare
            while (!scInput.hasNext("[123]")){
                System.out.println("Välj ett av menyvalen.");
                scInput.next();
            }
            userInput=scInput.next();
            switch (userInput){
                case "1":System.out.println("Derpderp");
                case "2":createNewUser();
                case "3":System.exit(0);
            }
        }
    }
    private void printMenuOptions(){
        System.out.println("[1]Spela Videopoker(inaktiv)");
        System.out.println("[2]Lägg till en ny Användare");
        System.out.println("[3]Stäng av");
    }

    private void createNewUser(){
        String name,password;
        int id = 0;
        //Hitta högsta Id nummer
        for (User user : userList){
            if (id < user.getId()){id = user.getId();}
        }
        id++;//Högsta ID+1
        name=createUserInputValidation();
        password=createUserInputValidation();
        userList.add(new User(id,name,password));
    }

    private String createUserInputValidation(){
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("^[\\p{L}0-9]*$")){
            System.out.println("Endast alfanumeriska tecken.");
            sc.next();
        }
        return sc.nextLine();
    }
}
