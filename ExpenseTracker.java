package learn;

import java.util.*;
import java.io.*;

public class ExpenseTracker {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> expenses = new ArrayList<>();
        HashMap<String, Double> categoryTotal = new HashMap<>();

        System.out.print("Enter number of expenses: ");
        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 1; i <= n; i++) {

            System.out.print("Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            System.out.print("Category: ");
            String category = sc.nextLine();

            System.out.print("Date: ");
            String date = sc.nextLine();

            expenses.add(amount + " | " + category + " | " + date);

            total += amount;

            categoryTotal.put(category,
                    categoryTotal.getOrDefault(category, 0.0) + amount);
        }

        // Display Expenses
        System.out.println("\nAll Expenses:");
        for (String e : expenses)
            System.out.println(e);

        // Monthly Report
        System.out.println("\nMonthly Expense Total = " + total);

        // Highest Expense Category
        String maxCat = "";
        double max = 0;

        for (String c : categoryTotal.keySet()) {
            if (categoryTotal.get(c) > max) {
                max = categoryTotal.get(c);
                maxCat = c;
            }
        }

        System.out.println("Highest Expense Category: " + maxCat);

        // Save to File
        FileWriter fw = new FileWriter("expenses.txt");
        for (String e : expenses)
            fw.write(e + "\n");
        fw.close();

        // Load from File
        System.out.println("\nLoaded From File:");
        Scanner file = new Scanner(new File("expenses.txt"));

        while (file.hasNextLine())
            System.out.println(file.nextLine());

        file.close();
        sc.close();
    }
}
