package task.simplebankingsystem;

import java.util.Scanner;

// Class representing a bank account
public class Account {
    private long accNo; // Unique identifier for the account
    private String name; // Name of the account holder
    private String branch; // Branch associated with the account
    private static String bankName = "State Bank of India"; // Static bank name
    private double balance; // Current balance of the account
    private String accountHolderAddress; // Address of the account holder

    // Constructor to initialize the account with provided values
    public Account(long accNo, String name, String branch, double balance, String accountHolderAddress) {
        this.accNo = accNo;
        this.name = name;
        this.branch = branch;
        this.balance = balance;
        this.accountHolderAddress = accountHolderAddress;
    }

    // Method to display account details
    public void showAccount() {
        System.out.println("Account Number: " + accNo);
        System.out.println("Account Holder Name: " + name);
        System.out.println("Branch: " + branch);
        System.out.println("Balance: " + balance);
        System.out.println("Account Holder Address: " + accountHolderAddress);
        System.out.println("Bank Name: " + bankName);
    }

    // Method to deposit money into the account
    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            System.out.println("Deposit Amount " + amt + " Available balance:" + balance);
        } else {
            System.out.println("Error: Negative deposit amount is not allowed");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amt) {
        if (amt > 0) {
            if (balance >= amt) {
                balance -= amt;
                System.out.println("Withdraw Amount " + amt + " Available balance:" + balance);
            } else {
                System.out.println("Error: Insufficient balance");
            }
        } else {
            System.out.println("Error: Negative withdrawal amount is not allowed");
        }
    }

    // Method to check the current balance of the account
    public void checkBalance() {
        System.out.println("Available balance: " + balance);
    }

    // Static method to validate and retrieve a valid account number from user input
    public static long getValidAccountNumber(Scanner scanner) {
        long accNo;
        while (true) {
            try {
                accNo = Long.parseLong(scanner.nextLine());
                break; // Exit loop if parsing successful
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid account number.");
                // Continue loop to allow the user to input again
            }
        }
        return accNo;
    }

    // Static method to validate and retrieve a valid amount from user input
    public static double getValidAmount(Scanner scanner) {
        double value;
        while (true) {
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value < 0) {
                    System.out.println("Error: Value cannot be negative.");
                    continue; // Continue loop to allow the user to input again
                }
                break; // Exit loop if parsing successful
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid balance.");
                // Continue loop to allow the user to input again
            }
        }
        return value;
    }
}
