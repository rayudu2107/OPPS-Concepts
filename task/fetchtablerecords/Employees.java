package task.fetchtablerecords;

import java.sql.*;
import java.util.Scanner;

public class Employees {
    // Scanner object for user input
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // Prompt user to provide MySQL database credentials
        System.out.println("Login to MySQL database by providing suitable credentials.");
        int portNumber = getValidPortNumber();
        String userName = getValidInput("Enter username (string):", 4);
        String password = getValidInput("Enter password (string with at least 4 characters):", 4);
        String schemaName = getValidInput("Enter the schema name (case-insensitive):", 1);

        // Construct JDBC URL using provided credentials
        String url = "jdbc:mysql://localhost:" + portNumber + "/" + schemaName;

        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            // Process the table data
            processTable(connection);
        } catch (SQLException e) {
            // Handle database connection errors
            System.out.println("Error: Please check the database connection details.");
        }
    }

    // Method to validate and retrieve valid port number from user input
    private static int getValidPortNumber() {
        while (true) {
            try {
                System.out.println("Please provide the database port number (numerical value):");
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                // Prompt user to enter a valid port number
                System.out.println("Invalid input: Please enter a valid port number.");
            }
        }
    }

    // Method to validate and retrieve valid user input with minimum length
    private static String getValidInput(String prompt, int minLength) {
        while (true) {
            System.out.println(prompt);
            String input = scan.nextLine();
            if (input.length() >= minLength) {
                return input;
            }
            // Prompt user to try again if input length is less than minimum length
            System.out.println("Invalid input. Please try again.");
        }
    }

    // Method to process table data
    private static void processTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            boolean validTableName = false;
            while (!validTableName) {
                System.out.println("Enter the table name (or 'exit' to quit):");
                String tableNameInSchema = scan.next();

                if (tableNameInSchema.equalsIgnoreCase("exit")) {
                    // Exit the program if user enters 'exit'
                    System.out.println("Exiting the program.");
                    break;
                }

                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableNameInSchema)) {
                    // Display data present inside the table
                    System.out.println("Data present inside the table:");
                    while (resultSet.next()) {
                        int employeeId = resultSet.getInt("employee_id");
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        String email = resultSet.getString("email");
                        String department = resultSet.getString("department");
                        String hireDate = resultSet.getString("hire_date");
                        // Display employee details
                        System.out.println("Employee ID: " + employeeId + ", Name: " + firstName + " " + lastName
                                + ", Email: " + email + ", Department: " + department + ", Hire Date: " + hireDate);
                    }
                    validTableName = true;
                } catch (SQLException e) {
                    if (e.getErrorCode() == 1146) {
                        // Handle table not found error
                        System.out.println("Error: Table '" + tableNameInSchema + "' does not exist.");
                    } else {
                        // Handle other database errors
                        System.out.println("Database error: " + e.getMessage());
                    }
                }
            }
        } catch (SQLException e) {
            // Handle SQL exception
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
