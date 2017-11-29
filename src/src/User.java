package src;

public class User {
    private int id, money;
    private String name, password;

    public User(int id, String name, String password) {
        this.id = id;
        this.money = 500;//Arbitrary cash deposit =)
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

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
