package constructorchaining;

class Account1 {
    String name;
    long Accno;
    double bal;

    public Account1(String name, long Accno) {
        this.name = name;
        this.Accno = Accno;
    }

    public Account1(String name, long Accno, double bal) {
        this(name, Accno);
        this.bal = bal;
    }

    void deposit(double amt) {
        if (amt >= 0) {
            bal += amt;
            System.out.println("Deposited amount: " + amt + ", Available balance: " + bal);
        } else {
            System.out.println("Negative amount");
        }
    }
    void withdrawal(double amt) {
        if (amt > 0 && bal >= amt) {
            bal -= amt;
            System.out.println("Withdrawal amount: " + amt + ", Available balance: " + bal);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class Savings extends Account1 {

    public Savings(String name, long Accno) {
        super(name, Accno);
    }
}

public class Account {
    public static void main(String[] args) {
        Savings S = new Savings("haresh", 123456l);
        S.deposit(1000.0);
        S.withdrawal(900);
        
        Savings s1=new Savings("Pradeep", 192004542);
        s1.deposit(50000);
    }
}
