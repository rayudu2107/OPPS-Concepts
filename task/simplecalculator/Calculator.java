package task.simplecalculator;

public class Calculator {
    // Method to perform addition with two integer numbers
    public void addition(int firstNumber, int secondNumber) {
        int result = firstNumber + secondNumber;
        System.out.println("Result: " + result);
    }

    // Method to perform addition with two double numbers (result rounded to nearest integer)
    public void addition(double firstNumber, double secondNumber) {
        double result = firstNumber + secondNumber;
        long roundedResult = Math.round(result); // Round to the nearest integer
        System.out.println("Result: " + roundedResult); // Print rounded result
    }

    // Method to perform addition with one double and one integer number (result rounded to nearest integer)
    public void addition(double firstNumber, int secondNumber) {
        double result = firstNumber + secondNumber;
        long roundedResult = Math.round(result); // Round to the nearest integer
        System.out.println("Result: " + roundedResult); // Print rounded result
    }

    // Method to perform addition with one integer and one double number (result rounded to nearest integer)
    public void addition(int firstNumber, double secondNumber) {
        double result = firstNumber + secondNumber;
        long roundedResult = Math.round(result); // Round to the nearest integer
        System.out.println("Result: " + roundedResult); // Print rounded result
    }

    // Method to perform subtraction with two integer numbers
    public void subtraction(int firstNumber, int secondNumber) {
        int result = firstNumber - secondNumber;
        System.out.println("Result: " + result);
    }

    // Method to perform subtraction with two double numbers (result rounded to nearest integer)
    public void subtraction(double firstNumber, double secondNumber) {
        double result = firstNumber - secondNumber;
        long roundedResult = Math.round(result); // Round to the nearest integer
        System.out.println("Result: " + roundedResult); // Print rounded result
    }

    // Method to perform subtraction with one double and one integer number (result rounded to nearest integer)
    public void subtraction(double firstNumber, int secondNumber) {
        double result = firstNumber - secondNumber;
        long roundedResult = Math.round(result); // Round to the nearest integer
        System.out.println("Result: " + roundedResult); // Print rounded result
    }

    // Method to perform subtraction with one integer and one double number (result rounded to nearest integer)
    public void subtraction(int firstNumber, double secondNumber) {
        double result = firstNumber - secondNumber;
        long roundedResult = Math.round(result); // Round to the nearest integer
        System.out.println("Result: " + roundedResult); // Print rounded result
    }

    
    // Method to perform multiplication with two integer numbers
    public void multiplication(int firstNumber, int secondNumber) {
        int result = firstNumber * secondNumber;
        System.out.println("Result: " + result);
    }

    // Method to perform multiplication with two double numbers (result rounded to nearest integer)
    public void multiplication(double firstNumber, double secondNumber) {
        double result = firstNumber * secondNumber;
        long roundedResult = Math.round(result); // Round to the nearest integer
        System.out.println("Result: " + roundedResult); // Print rounded result
    }

    // Method to perform multiplication with one double and one integer number (result rounded to nearest integer)
    public void multiplication(double firstNumber, int secondNumber) {
        double result = firstNumber * secondNumber;
        long roundedResult = Math.round(result); // Round to the nearest integer
        System.out.println("Result: " + roundedResult); // Print rounded result
    }

    // Method to perform multiplication with one integer and one double number (result rounded to nearest integer)
    public void multiplication(int firstNumber, double secondNumber) {
        double result = firstNumber * secondNumber;
        long roundedResult = Math.round(result); // Round to the nearest integer
        System.out.println("Result: " + roundedResult); // Print rounded result
    }

    // Method to perform division with two integer numbers
    public void division(int firstNumber, int secondNumber) {
        if (secondNumber != 0) {
            int result = firstNumber / secondNumber;
            System.out.println("Result: " + result);
        } else {
            System.out.println("Cannot divide by zero!");
        }
    }

    // Method to perform division with two double numbers (result rounded to nearest integer)
    public void division(double firstNumber, double secondNumber) {
        if (secondNumber != 0) {
            double result = firstNumber / secondNumber;
            long roundedResult = Math.round(result); // Round to the nearest integer
            System.out.println("Result: " + roundedResult); // Print rounded result
        } else {
            System.out.println("Cannot divide by zero!");
        }
    }

    // Method to perform division with one double and one integer number (result rounded to nearest integer)
    public void division(double firstNumber, int secondNumber) {
        if (secondNumber != 0) {
            double result = firstNumber / secondNumber;
            long roundedResult = Math.round(result); // Round to the nearest integer
            System.out.println("Result: " + roundedResult); // Print rounded result
        } else {
            System.out.println("Cannot divide by zero!");
        }
    }

    // Method to perform division with one integer and one double number (result rounded to nearest integer)
    public void division(int firstNumber, double secondNumber) {
        if (secondNumber != 0) {
            double result = firstNumber / secondNumber;
            long roundedResult = Math.round(result); // Round to the nearest integer
            System.out.println("Result: " + roundedResult); // Print rounded result
        } else {
            System.out.println("Cannot divide by zero!");
        }
    }
}
