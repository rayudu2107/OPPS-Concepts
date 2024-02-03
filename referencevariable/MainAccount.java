package referencevariable;
class Account {
    long accNo;
    String name;
    String branch;
    static String bankName = "State Bank of India";
    double balance;
    String account_holder_address;

    public Account(long accNo, String name, String branch, double balance, String account_holder_address) {
        this.accNo = accNo;
        this.name = name;
        this.branch = branch;
        this.balance = balance;
        this.account_holder_address = account_holder_address;
    }

    public void showAccount() {
        System.out.println("Account Number: " + accNo);
        System.out.println("Account Holder Name: " + name);
        System.out.println("Branch: " + branch);
        System.out.println("Balance: " + balance);
        System.out.println("Account Holder Address: " + account_holder_address);
        System.out.println("Bank Name: " + bankName);
    }

    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt; 
            System.out.println("Deposit Amount "+amt+ "Available balance:"+balance);
        } else {
            System.out.println("Negative deposit amount is not allowed");
        }
    }

    public void withdraw(double amt) {
        if (amt > 0) {
            if (balance >= amt) {
                balance -= amt; 
                System.out.println("Withdraw Amount "+amt+ "Available balance:"+balance);
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

public class MainAccount {
    public static void main(String[] args) {
        Account a = new Account(19200454261L, "Haresh", "D.Hirehal0", 1000, "BELLARY");
        a.showAccount();
        a.deposit(1000);
        a.withdraw(5000);
        a.checkBalance();
    }
}
