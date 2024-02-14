package task.simplecalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

// Class representing a simple calculator application
public class SimpleCalculator {
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

    // Method to get valid numerical input (int or double) from the user
    public static Object getInput(Scanner scanner) {
        try {
            if (scanner.hasNextInt()) {
                int intValue = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                return intValue;
            } else if (scanner.hasNextDouble()) {
                double doubleValue = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                return doubleValue;
            } else {
                scanner.nextLine(); // Consume invalid input
                return null;
            }
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Consume invalid input
            return null;
        }
    }

    // Method to perform arithmetic operations based on user input
    public static void performOperation(Object firstInput, Object secondInput) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Enter 1 for addition\n"
                + "Enter 2 for subtraction\n"
                + "Enter 3 for multiplication\n"
                + "Enter 4 for division\n"
                + "5. Exit");
        int opt = scanner.nextInt();

        switch (opt) {
            case 1:
                calculator.addition(firstInput, secondInput);
                break;
            case 2:
                calculator.subtraction(firstInput, secondInput);
                break;
            case 3:
                calculator.multiplication(firstInput, secondInput);
                break;
            case 4:
                calculator.division(firstInput, secondInput);
                break;
            case 5:
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
