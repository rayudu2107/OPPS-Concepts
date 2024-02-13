package task.simplebankingsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleBankingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Simple Banking System!");
        Map<Long, Account> accounts = new HashMap<>(); // Map to store accounts

        // menu and process user input
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
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer choice.");
                continue;
            }

            System.out.println("========================================================================");

            // Switch statement to handle user choices
            switch (choice) {
                case 1: // Creating a bank account
                    System.out.println("Enter account number: ");
                    long accNo = Account.getValidAccountNumber(input);
                    if (accounts.containsKey(accNo)) {
                        System.out.println("Error: Account already exists.");
                        break;
                    }
                    System.out.print("Enter name: ");
                    String name = input.nextLine();
                    System.out.println("Enter the Branch name:");
                    String branch = input.nextLine();
                    System.out.println("Enter account holder address: ");
                    String accountHolderAddress = input.nextLine();
                    double initialBalance;
                    do {
                        System.out.print("Enter initial balance for Bank Account (should be non-negative): ");
                        initialBalance = Account.getValidAmount(input);
                    } while (initialBalance < 0);
                    Account userAccount = new Account(accNo, name, branch, initialBalance, accountHolderAddress);
                    accounts.put(accNo, userAccount);
                    System.out.println("Bank Account created for Account Number: " + accNo + " Account Holder Name: " + name);
                    break;

                case 2: // Depositing money into an account
                    System.out.print("Enter account number: ");
                    long depositAccNo = Account.getValidAccountNumber(input);
                    Account depositAccount = accounts.get(depositAccNo);
                    if (depositAccount != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = Account.getValidAmount(input);
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found for deposit.");
                    }
                    break;

                case 3: // Withdrawing money from an account
                    System.out.print("Enter account number: ");
                    long withdrawAccNo = Account.getValidAccountNumber(input);
                    Account withdrawAccount = accounts.get(withdrawAccNo);
                    if (withdrawAccount != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = Account.getValidAmount(input);
                        withdrawAccount.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("Account not found for withdrawal.");
                    }
                    break;

                case 4: // Checking account balance
                    System.out.print("Enter account number: ");
                    long checkBalanceAccNo = Account.getValidAccountNumber(input);
                    Account checkBalanceAccount = accounts.get(checkBalanceAccNo);
                    if (checkBalanceAccount != null) {
                        checkBalanceAccount.checkBalance();
                    } else {
                        System.out.println("Error: Account not found for balance check.");
                    }
                    break;

                case 5: // Showing account details
                    System.out.print("Enter account number: ");
                    long showDetailsAccNo = Account.getValidAccountNumber(input);
                    Account showDetailsAccount = accounts.get(showDetailsAccNo);
                    if (showDetailsAccount != null) {
                        showDetailsAccount.showAccount();
                    } else {
                        System.out.println("Error: Account not found for details.");
                    }
                    break;

                case 6: // Exiting the program
                    System.out.println("Thank you for using Simple Banking System!");
                    input.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Error: Invalid choice.");
            }
        }
    }
}
