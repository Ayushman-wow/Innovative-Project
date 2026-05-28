package learn;

import java.util.Scanner;
import java.util.Random;

public class SmartPasswordGenerator {

    // Method to check password strength
    static String checkStrength(String password) {

        int score = 0;

        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[@#$&*!].*")) score++;
        if (password.length() >= 10) score++;

        if (score <= 2)
            return "Weak";
        else if (score <= 4)
            return "Medium";
        else
            return "Strong";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Enter number of users: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nUser " + i);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter PAN: ");
            String pan = sc.nextLine();

            System.out.print("Enter DOB (DD/MM/YYYY): ");
            String dob = sc.nextLine();

            char special[] = {'@', '#', '$', '&', '!'};

            String password =
                    name.substring(0,2).toUpperCase() +
                    pan.substring(0,4) +
                    special[r.nextInt(5)] +
                    dob.replace("/", "").substring(0,4) +
                    (100 + r.nextInt(900));

            System.out.println("Generated Password: " + password);

            System.out.println("Password Strength: " + checkStrength(password));
        }

        sc.close();
    
    }
}
