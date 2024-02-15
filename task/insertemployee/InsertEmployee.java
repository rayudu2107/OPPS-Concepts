package task.insertemployee;

import java.util.Scanner;
import java.sql.*;

public class InsertEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Prompt the user to input database URL, username, and password
            System.out.println("Enter database URL:");
            String url = scanner.nextLine();

            System.out.println("Enter username:");
            String username = scanner.nextLine();

            System.out.println("Enter password:");
            String password = scanner.nextLine();

            // Establish connection to the database using user input
            connection = DriverManager.getConnection(url, username, password);

            // Create a PreparedStatement with parameterized query
            String query = "INSERT INTO employee (id, name, age, department) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);

            // Prompt the user to input values for id, name, age, and department
            System.out.println("Enter employee id:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            System.out.println("Enter employee name:");
            String name = scanner.nextLine();

            // Validate and input employee age
            int age = 0;
            while (true) {
                System.out.println("Enter employee age:");
                String ageInput = scanner.nextLine();
                try {
                    age = Integer.parseInt(ageInput);
                    if (age > 0 && age < 150) { // Assuming a reasonable age range
                        break; // Exit loop if age is valid
                    } else {
                        System.out.println("Please enter a valid age.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Age must be a valid integer.");
                }
            }

            System.out.println("Enter employee department:");
            String department = scanner.nextLine();

            // Set the parameter values
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, department);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee record inserted successfully.");
            } else {
                System.out.println("Failed to insert employee record.");
            }

        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the resources in a finally block
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                scanner.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
