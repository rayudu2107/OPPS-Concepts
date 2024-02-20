package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            // Get connection properties
            String url = getUserInput(scanner, "Enter database URL:", "URL cannot be empty.");
            String username = getUserInput(scanner, "Enter username:", "Username cannot be empty.");
            String password = getUserInput(scanner, "Enter password:", "Password cannot be empty.");

            // Establish connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create EmployeeDao object with established connection
            EmployeeUsingStmtDao employeeDao = new EmployeeUsingStmtDao(connection,scanner);

            // Menu for CRUD operations
            while (true) {
                System.out.println("1. Insert Employee");
                System.out.println("2. Update Employee");
                System.out.println("3. Delete Employee");
                System.out.println("4. Get Employee by ID");
                System.out.println("5. Get All Employees");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice;
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                    continue;
                }

                switch (choice) {
                    case 1:
                        employeeDao.insertEmployee();
                        break;
                    case 2:
                        employeeDao.updateEmployeeById();
                        break;
                    case 3:
                        employeeDao.deleteEmployeeById();
                        break;
                    case 4:
                        employeeDao.getEmployeeById();
                        break;
                    case 5:
                        employeeDao.getAllEmployees();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        scanner.close(); // Close the scanner before exiting
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }  catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        } finally {
            scanner.close(); // Close the scanner in the finally block to ensure it's closed even if an exception occurs
        }
    }

    private static String getUserInput(Scanner scanner, String prompt, String errorMessage) {
        System.out.println(prompt);
        String input;
        while (true) {
            try {
                input = scanner.nextLine().trim();
                if (!input.isEmpty()) {
                    return input;
                } else {
                    System.out.println(errorMessage);
                }
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
}
