package task.simplebankingsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class representing a bank that manages accounts
public class Bank {
    private Map<Long, Account> accounts = new HashMap<>(); // Map to store accounts with their account numbers as keys

    // Method to create a new bank account
    public void createAccount(Scanner scanner) {
        System.out.println("Enter account number: ");
        long accNo = Account.getValidAccountNumber(scanner); // Get a valid account number from user input
        if (accounts.containsKey(accNo)) {
            System.out.println("Error: Account already exists.");
            return;
        }
        System.out.print("Enter name: ");
        String name = scanner.nextLine(); // Get account holder's name from user input
        System.out.println("Enter the Branch name:");
        String branch = scanner.nextLine(); // Get branch name from user input
        System.out.println("Enter account holder address: ");
        String accountHolderAddress = scanner.nextLine(); // Get account holder's address from user input
        double initialBalance;
        do {
            System.out.print("Enter initial balance for Bank Account (should be non-negative): ");
            initialBalance = Account.getValidAmount(scanner); // Get initial balance from user input
        } while (initialBalance < 0); // Ensure initial balance is non-negative
        Account userAccount = new Account(accNo, name, branch, initialBalance, accountHolderAddress); // Create new account object
        accounts.put(accNo, userAccount); // Add account to the map
        System.out.println("Bank Account created for Account Number: " + accNo + " Account Holder Name: " + name);
    }

    // Method to deposit money into an existing account
    public void deposit(Scanner scanner) {
        System.out.print("Enter account number: ");
        long depositAccNo = Account.getValidAccountNumber(scanner); // Get account number from user input
        Account depositAccount = accounts.get(depositAccNo); // Retrieve account object using account number
        if (depositAccount != null) {
            System.out.print("Enter deposit amount: ");
            double depositAmount = Account.getValidAmount(scanner); // Get deposit amount from user input
            depositAccount.deposit(depositAmount); // Deposit money into the account
        } else {
            System.out.println("Account not found for deposit.");
        }
    }

    // Method to withdraw money from an existing account
    public void withdraw(Scanner scanner) {
        System.out.print("Enter account number: ");
        long withdrawAccNo = Account.getValidAccountNumber(scanner); // Get account number from user input
        Account withdrawAccount = accounts.get(withdrawAccNo); // Retrieve account object using account number
        if (withdrawAccount != null) {
            System.out.print("Enter withdrawal amount: ");
            double withdrawalAmount = Account.getValidAmount(scanner); // Get withdrawal amount from user input
            withdrawAccount.withdraw(withdrawalAmount); // Withdraw money from the account
        } else {
            System.out.println("Account not found for withdrawal.");
        }
    }

    // Method to check the balance of an existing account
    public void checkBalance(Scanner scanner) {
        System.out.print("Enter account number: ");
        long checkBalanceAccNo = Account.getValidAccountNumber(scanner); // Get account number from user input
        Account checkBalanceAccount = accounts.get(checkBalanceAccNo); // Retrieve account object using account number
        if (checkBalanceAccount != null) {
            checkBalanceAccount.checkBalance(); // Check the balance of the account
        } else {
            System.out.println("Error: Account not found for balance check.");
        }
    }

    // Method to display the details of an existing account
    public void showAccountDetails(Scanner scanner) {
        System.out.print("Enter account number: ");
        long showDetailsAccNo = Account.getValidAccountNumber(scanner); // Get account number from user input
        Account showDetailsAccount = accounts.get(showDetailsAccNo); // Retrieve account object using account number
        if (showDetailsAccount != null) {
            showDetailsAccount.showAccount(); // Display the details of the account
        } else {
            System.out.println("Error: Account not found for details.");
        }
    }
}
