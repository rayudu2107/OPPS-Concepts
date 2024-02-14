package task.simplecalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Simple Calculator");

        while (true) {
            double firstNumber, secondNumber;
            try {
                System.out.print("Enter first number:");
                firstNumber = scanner.nextDouble();

                System.out.print("Enter second number:");
                secondNumber = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }

            System.out.println("Enter 1 for addition\n"
                    + "Enter 2 for subtraction\n"
                    + "Enter 3 for multiplication\n"
                    + "Enter 4 for division\n"
                    + "Enter 5 to exit");
            int opt = scanner.nextInt();

            switch (opt) {
                case 1:
                    printResult(firstNumber + secondNumber);
                    break;
                case 2:
                    printResult(firstNumber - secondNumber);
                    break;
                case 3:
                    printResult(firstNumber * secondNumber);
                    break;
                case 4:
                    if (secondNumber != 0) {
                        printResult(firstNumber / secondNumber);
                    } else {
                        System.out.println("Do not divide by zero!");
                    }
                    break;
                case 5:
                    System.out.println("Exiting Simple Calculator. Goodbye!");
                    return; // Exit the program
                default:
                    System.out.println("Invalid operator!");
            }
        }
    }

    private static final double TOLERANCE = 1e-10;

    private static void printResult(double result) {
        if (Math.abs(result - Math.round(result)) < TOLERANCE) {
            System.out.println("Result: " + (int) Math.round(result));
        } else {
            System.out.println("Result: " + result);
        }
    }

}
