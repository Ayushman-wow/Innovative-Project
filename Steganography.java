package learn;

import java.util.*;
import java.io.*;

public class Steganography {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cover text: ");
        String cover = sc.nextLine();

        System.out.print("Enter secret message: ");
        String secret = sc.nextLine();

        // Encode and save
        FileWriter fw = new FileWriter("encoded.txt");
        fw.write(cover + "\n###" + secret);
        fw.close();

        System.out.println("\nEncoded file saved.");

        // Decode
        Scanner file = new Scanner(new File("encoded.txt"));
        file.nextLine(); // skip cover text
        String hidden = file.nextLine().substring(3);

        System.out.println("Retrieved Message: " + hidden);

        file.close();
        sc.close();
    }
}

