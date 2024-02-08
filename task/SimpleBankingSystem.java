package task;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    long accNo;
    String name;
    String branch;
    static String bankName = "State Bank of India";
    double balance;
    String accountHolderAddress;

    public Account(long accNo, String name, String branch, double balance, String accountHolderAddress) {
        this.accNo = accNo;
        this.name = name;
        this.branch = branch;
        this.balance = balance;
        this.accountHolderAddress = accountHolderAddress;
    }

    public void showAccount() {
        System.out.println("Account Number: " + accNo);
        System.out.println("Account Holder Name: " + name);
        System.out.println("Branch: " + branch);
        System.out.println("Balance: " + balance);
        System.out.println("Account Holder Address: " + accountHolderAddress);
        System.out.println("Bank Name: " + bankName);
    }

    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            System.out.println("Deposit Amount " + amt + " Available balance:" + balance);
        } else {
            System.out.println("Negative deposit amount is not allowed");
        }
    }

    public void withdraw(double amt) {
        if (amt > 0) {
            if (balance >= amt) {
                balance -= amt;
                System.out.println("Withdraw Amount " + amt + " Available balance:" + balance);
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Negative withdrawal amount is not allowed");
        }
    }

    public void checkBalance() {
        System.out.println("Available balance: " + balance);
    }
}

public class SimpleBankingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Simple Banking System!");
        Map<Long, Account> accounts = new HashMap<>();

        while (true) {
        	System.out.println("========================================================================");
            System.out.print("1. Create Bank Account\n"
            		+ "2. Deposit\n"
            		+ "3. Withdraw\n"
            		+ "4. Check Balance\n"
            		+ "5. Show Account Details\n"
            		+ "6. Exit\n"
            		+ "Enter your choice: ");
            int choice = input.nextInt();
            System.out.println("========================================================================");
            switch (choice) {
                case 1:
                    System.out.println("Enter account number: ");
                    long accNo = input.nextLong();
                    input.nextLine();
                    System.out.print("Enter name: ");
                    String name = input.nextLine();
                    System.out.println("Enter the Branch name:");
                    String branch = input.nextLine();
                    System.out.println("Enter account holder address: ");
                    String accountHolderAddress = input.nextLine();
                    System.out.print("Enter initial balance for Bank Account: ");
                    double initialBalance = input.nextDouble();
                    Account userAccount = new Account(accNo, name, branch, initialBalance, accountHolderAddress);
                    accounts.put(accNo, userAccount);
                    System.out.println("Bank Account created for " + "Account Number: " + accNo + " Account Holder Name: " + name);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    long depositAccNo = input.nextLong();
                    Account depositAccount = accounts.get(depositAccNo);
                    if (depositAccount != null) {
                    	System.out.print("Enter deposit amount: ");
                        double depositAmount = input.nextDouble();
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found for deposit.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    long withdrawAccNo = input.nextLong();
                    Account withdrawAccount = accounts.get(withdrawAccNo);
                    if (withdrawAccount != null) {
                    	System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = input.nextDouble();
                        withdrawAccount.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("Account not found for withdrawal.");
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    long checkBalanceAccNo = input.nextLong();
                    Account checkBalanceAccount = accounts.get(checkBalanceAccNo);
                    if (checkBalanceAccount != null) {
                        checkBalanceAccount.checkBalance();
                    } else {
                        System.out.println("Account not found for balance check.");
                    }
                    break;
                case 5:
                    System.out.print("Enter account number: ");
                    long showDetailsAccNo = input.nextLong();
                    Account showDetailsAccount = accounts.get(showDetailsAccNo);
                    if (showDetailsAccount != null) {
                        showDetailsAccount.showAccount();
                    } else {
                        System.out.println("Account not found for details.");
                    }
                    break;
                case 6:
                    System.out.println("Thank you for using Simple Banking System!");
                    input.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
