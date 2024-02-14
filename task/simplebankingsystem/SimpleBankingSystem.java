package task.simplebankingsystem;

import java.util.Scanner;

// Class representing the main entry point for the Simple Banking System
public class SimpleBankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        System.out.println("Welcome to Simple Banking System!"); // Welcome message
        Bank bank = new Bank(); // Create a Bank object to manage accounts

        try {
            // Main menu and user interaction loop
            while (true) {
                System.out.println("========================================================================");
                System.out.print("1. Create Bank Account\n"
                        + "2. Deposit\n"
                        + "3. Withdraw\n"
                        + "4. Check Balance\n"
                        + "5. Show Account Details\n"
                        + "6. Exit\n"
                        + "Enter your choice: ");
                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine()); // Get user choice
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid integer choice.");
                    continue;
                }

                System.out.println("========================================================================");

                // Switch statement to handle user choices
                switch (choice) {
                    case 1:
                        bank.createAccount(scanner); // Create a new bank account
                        break;
                    case 2:
                        bank.deposit(scanner); // Deposit money into an account
                        break;
                    case 3:
                        bank.withdraw(scanner); // Withdraw money from an account
                        break;
                    case 4:
                        bank.checkBalance(scanner); // Check the balance of an account
                        break;
                    case 5:
                        bank.showAccountDetails(scanner); // Show details of an account
                        break;
                    case 6:
                        System.out.println("Thank you for using Simple Banking System!"); // Exit message
                        System.exit(0); // Exit the program
                        break;
                    default:
                        System.out.println("Error: Invalid choice."); // Error message for invalid input
                }
            }
        } finally {
            scanner.close(); // Close the scanner to release resources
        }
    }
}
