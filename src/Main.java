package src;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<User> import_data() {
        
        try (Scanner file = new Scanner(new File("Users"))) {
            while(file.hasNextLine()) {
                String line = file.nextLine();
                User.Users.add(new User(line.split(" ")[0], Byte.parseByte(line.split(" ")[1])));
            }
        } catch (Exception e) {}
        return User.Users;
    }
    public static void main(String[] args) {

        import_data();
        
        Scanner input = new Scanner(System.in);
        
        String name = "";
        byte age = 0;
        String option = "";
        
        while (!option.toLowerCase().equals("q")) {
            while (name == "") {
                try {
                    System.out.print("Enter your name: ");
                    name = input.nextLine().trim();
                } catch (Exception e) {
                    continue;
                }
            }

            while (age == 0) {
                try {
                    System.out.print("Enter your age: ");
                    age = Byte.parseByte(input.nextLine().trim());
                } catch (Exception e) {
                    continue;
                }
            }

            User.Users.add(new User(name, age));

            File Data = new File("Users");
            try {
                Data.createNewFile();
            } catch (Exception e) {
                System.err.println("Cannot create users file");
            }

            try (FileWriter out = new FileWriter("Users")) {
                out.write("");
                for (User u : User.Users) {
                    out.append(u.getName() + ' ' + u.getAge() + '\n');
                }
                out.flush();
            } catch (Exception e) {
                System.err.println("Cannot output users to file");
            }
            
            name = "";
            age = 0;

            System.out.print("'Q' to quit, 'L' to list users: ");
            option = input.nextLine();
            if (option.toLowerCase().equals("l")) {
                for (User u : User.Users) {
                    System.out.println("{ " + User.RED_BOLD + "name: " + User.WHITE_BOLD + u.getName() +
                    ", " + User.GREEN_BOLD + "age: " + User.WHITE_BOLD + u.getAge() + User.RESET + " }");
                }
            }
        }

        input.close();
    }
}