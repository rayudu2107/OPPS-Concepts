package interfaces;
import java.util.Scanner;

interface Bank {
    void deposit(double amt);

    void withdraw(double amt);

    void checkBalance();
}

class BankImpl implements Bank {
    double balance = 5000;

    @Override
    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            System.out.println("Deposit Rs." + amt + "  Available Balance is Rs." + balance);
        } else {
            System.out.println("Negative balance is not allowed");
        }
    }

    @Override
    public void withdraw(double amt) {
        double minBal = 500;
        if (amt > 0 && balance - minBal >= amt) {
            balance -= amt;
            System.out.println("Withdraw Rs." + amt + "  Available Balance is Rs." + balance);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Available Balance is Rs." + balance);
    }
}

public class Account {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankImpl bankImpl = new BankImpl();
        int choice = -1;

        while (choice != 0) {
            System.out.println("1.Deposit\n"
                    + "2.Withdraw\n"
                    + "3.Check Balance\n"
                    + "0.Exit\n"
                    + "Enter the choice");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to deposit");
                    double amt = scanner.nextDouble();
                    bankImpl.deposit(amt);
                    System.out.println("Deposit successful");
                    break;
                case 2:
                    System.out.println("Enter the amount to withdraw");
                    double amtWith = scanner.nextDouble();
                    bankImpl.withdraw(amtWith);
                    System.out.println("Withdraw successful");
                    break;
                case 3:
                    bankImpl.checkBalance();
                    break;
                case 0:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        scanner.close();
    }
}
