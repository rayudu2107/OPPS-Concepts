package task.simplecalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleCalculator {
    // Main method to start the Simple Calculator program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Simple Calculator");

        while (true) {
            System.out.println("Enter first number:");
            Object firstInput = getInput(scanner); // Get the first input
            if (firstInput != null) {
                System.out.println("Enter second number:");
                Object secondInput = getInput(scanner); // Get the second input
                if (secondInput != null) {
                    performOperation(firstInput, secondInput); // Perform the selected operation
                } else {
                    System.out.println("Invalid input detected.");
                }
            } else {
                System.out.println("Invalid input detected.");
            }
        }
    }

    // Method to get input from the user
    public static Object getInput(Scanner scanner) {
        try {
            if (scanner.hasNextInt()) {
                int intValue = scanner.nextInt();
                // Consume the newline character
                scanner.nextLine();
                return intValue;
            } else if (scanner.hasNextDouble()) {
                double doubleValue = scanner.nextDouble();
                // Consume the newline character
                scanner.nextLine();
                return doubleValue;
            } else {
                // Consume the invalid token
                scanner.nextLine();
                return null;
            }
        } catch (InputMismatchException e) {
            // Consume the invalid token
            scanner.nextLine();
            return null;
        }
    }

    // Method to perform the selected operation
    public static void performOperation(Object firstInput, Object secondInput) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        // Prompt the user to select the operation
        System.out.println("Enter 1 for addition\n"
                + "Enter 2 for subtraction\n"
                + "Enter 3 for multiplication\n"
                + "Enter 4 for division\n"
                + "5. Exit");
        int opt = scanner.nextInt();

        switch (opt) {
            case 1:
                // Addition operation
                if (firstInput instanceof Integer && secondInput instanceof Integer) {
                    calculator.addition((int) firstInput, (int) secondInput);
                } else if (firstInput instanceof Double && secondInput instanceof Double) {
                    calculator.addition((double) firstInput, (double) secondInput);
                } else if (firstInput instanceof Double && secondInput instanceof Integer) {
                    calculator.addition((double) firstInput, (int) secondInput);
                } else if (firstInput instanceof Integer && secondInput instanceof Double) {
                    calculator.addition((int) firstInput, (double) secondInput);
                }
                break;
            case 2:
                // Subtraction operation
                if (firstInput instanceof Integer && secondInput instanceof Integer) {
                    calculator.subtraction((int) firstInput, (int) secondInput);
                } else if (firstInput instanceof Double && secondInput instanceof Double) {
                    calculator.subtraction((double) firstInput, (double) secondInput);
                } else if (firstInput instanceof Double && secondInput instanceof Integer) {
                    calculator.subtraction((double) firstInput, (int) secondInput);
                } else if (firstInput instanceof Integer && secondInput instanceof Double) {
                    calculator.subtraction((int) firstInput, (double) secondInput);
                }
                break;
            case 3:
                // Multiplication operation
                if (firstInput instanceof Integer && secondInput instanceof Integer) {
                    calculator.multiplication((int) firstInput, (int) secondInput);
                } else if (firstInput instanceof Double && secondInput instanceof Double) {
                    calculator.multiplication((double) firstInput, (double) secondInput);
                } else if (firstInput instanceof Double && secondInput instanceof Integer) {
                    calculator.multiplication((double) firstInput, (int) secondInput);
                } else if (firstInput instanceof Integer && secondInput instanceof Double) {
                    calculator.multiplication((int) firstInput, (double) secondInput);
                }
                break;
            case 4:
                // Division operation
                if (firstInput instanceof Integer && secondInput instanceof Integer) {
                    calculator.division((int) firstInput, (int) secondInput);
                } else if (firstInput instanceof Double && secondInput instanceof Double) {
                    calculator.division((double) firstInput, (double) secondInput);
                } else if (firstInput instanceof Double && secondInput instanceof Integer) {
                    calculator.division((double) firstInput, (int) secondInput);
                } else if (firstInput instanceof Integer && secondInput instanceof Double) {
                    calculator.division((int) firstInput, (double) secondInput);
                }
                break;
            case 5: // Exiting the program
                System.out.println("Thank you for using Simple Calculator!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid operator!");
        }
        System.out.println("========================================================================");
        
    }
}
