package exceptionhandling.customexception;

import java.util.Scanner;

class InsufficientBalanceException extends RuntimeException {
    private String message;

    public InsufficientBalanceException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

public class Atm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the amount to be withdrawn:");
        int amt = s.nextInt();
        int bal = 5000;
        if (bal >= amt) {
            System.out.println("Amount withdrawn successfully");
        } else {
            try {
                throw new InsufficientBalanceException("Insufficient Balance");
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
