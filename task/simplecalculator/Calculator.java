// Calculator.java
package task.simplecalculator;

public class Calculator {
	 // Method to perform addition operation
    public void addition(Object firstInput, Object secondInput) {
        if (firstInput instanceof Integer && secondInput instanceof Integer) {
            System.out.println("Result: " + ((int) firstInput + (int) secondInput));
        } else if (firstInput instanceof Double && secondInput instanceof Double) {
            double result = (double) firstInput + (double) secondInput;
            printRoundedResult(result);
        } else if (firstInput instanceof Double && secondInput instanceof Integer) {
            double result = (double) firstInput + (int) secondInput;
            printRoundedResult(result);
        } else if (firstInput instanceof Integer && secondInput instanceof Double) {
            double result = (int) firstInput + (double) secondInput;
            printRoundedResult(result);
        } else {
            System.out.println("Invalid input types for addition.");
        }
    }
    // Method to perform subtraction operation
    public void subtraction(Object firstInput, Object secondInput) {
        if (firstInput instanceof Integer && secondInput instanceof Integer) {
            System.out.println("Result: " + ((int) firstInput - (int) secondInput));
        } else if (firstInput instanceof Double && secondInput instanceof Double) {
            double result = (double) firstInput - (double) secondInput;
            printRoundedResult(result);
        } else if (firstInput instanceof Double && secondInput instanceof Integer) {
            double result = (double) firstInput - (int) secondInput;
            printRoundedResult(result);
        } else if (firstInput instanceof Integer && secondInput instanceof Double) {
            double result = (int) firstInput - (double) secondInput;
            printRoundedResult(result);
        } else {
            System.out.println("Invalid input types for subtraction.");
        }
    }
    // Method to perform multiplication operation
    public void multiplication(Object firstInput, Object secondInput) {
        if (firstInput instanceof Integer && secondInput instanceof Integer) {
            System.out.println("Result: " + ((int) firstInput * (int) secondInput));
        } else if (firstInput instanceof Double && secondInput instanceof Double) {
            double result = (double) firstInput * (double) secondInput;
            printRoundedResult(result);
        } else if (firstInput instanceof Double && secondInput instanceof Integer) {
            double result = (double) firstInput * (int) secondInput;
            printRoundedResult(result);
        } else if (firstInput instanceof Integer && secondInput instanceof Double) {
            double result = (int) firstInput * (double) secondInput;
            printRoundedResult(result);
        } else {
            System.out.println("Invalid input types for multiplication.");
        }
    }
    // Method to perform division operation
    public void division(Object firstInput, Object secondInput) {
        if (firstInput instanceof Integer && secondInput instanceof Integer) {
            int secondNumber = (int) secondInput;
            if (secondNumber != 0) {
                System.out.println("Result: " + ((int) firstInput / secondNumber));
            } else {
                System.out.println("Cannot divide by zero!");
            }
        } else if (firstInput instanceof Double && secondInput instanceof Double) {
            double secondNumber = (double) secondInput;
            if (secondNumber != 0) {
                double result = (double) firstInput / secondNumber;
                printRoundedResult(result);
            } else {
                System.out.println("Cannot divide by zero!");
            }
        } else if (firstInput instanceof Double && secondInput instanceof Integer) {
            int secondNumber = (int) secondInput;
            if (secondNumber != 0) {
                double result = (double) firstInput / secondNumber;
                printRoundedResult(result);
            } else {
                System.out.println("Cannot divide by zero!");
            }
        } else if (firstInput instanceof Integer && secondInput instanceof Double) {
            double secondNumber = (double) secondInput;
            if (secondNumber != 0) {
                double result = (int) firstInput / secondNumber;
                printRoundedResult(result);
            } else {
                System.out.println("Cannot divide by zero!");
            }
        } else {
            System.out.println("Invalid input types for division.");
        }
    }
    //print the rounded result
    private void printRoundedResult(double result) {
        long roundedResult = Math.round(result);
        System.out.println("Result: " + roundedResult);
    }
}