package task;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Simple Calculator");

        double m, n, result;

        System.out.print("Enter first number:");
        m = scanner.nextInt();

        System.out.print("Enter second number:");
        n = scanner.nextInt();

        	   System.out.println("Enter 1 for addition\n"
	            		+ "Enter 2 for subtraction\n"
	            		+ "Enter 3 for multiplication\n"
	            		+ "Enter 4 for division");
          int opt = scanner.nextInt();

            switch (opt) {
                case 1:
                    result = m + n;
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    result = m - n;
                    System.out.println("Result: " + result);
                    break;
                case 3:
                    result = m * n;
                    System.out.println("Result: " + result);
                    break;
                case 4:
                    if (n != 0) {
                        double division = (double) m / n;
                        System.out.println("Result: " + division);
                    } else {
                        System.out.println("Do not be devided by zero!");
                    }
                    break;
                default:
                    System.out.println("Invalid operator!");
            }
        }
    }

