package src;

import java.util.ArrayList;

public class User {

    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
    public static final String RESET = "\033[0m";  // Text Reset

    private String name;
    private byte age;
    // private JSONObject obj;
    public static ArrayList<User> Users = new ArrayList<>();

    public User(String name, byte age) {
        this.name = name;
        this.age = age;
    }

    public byte getAge() { return age; }
    public String getName() { return name; }

    public void setAge(byte age) { this.age = age; }
    public void setName(String name) { this.name = name; }
}
