package task.insertemployee;

import java.util.Scanner;
import java.sql.*;

public class InsertEmployee {
    public static void main(String[] args) {
        try {
            // Load and register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Prompt the user to input database URL, username, and password
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter database URL:");
            String url = scanner.nextLine();

            System.out.println("Enter username:");
            String username = scanner.nextLine();

            System.out.println("Enter password:");
            String password = scanner.nextLine();

            // Establish connection to the database using user input
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a PreparedStatement with parameterized query
            String query = "INSERT INTO employee (name, age, department) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            // Prompt the user to input values for name, age, and department
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
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, department);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Retrieve the generated keys (including the auto-generated id)
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1); // Assuming id is of type INT
                    System.out.println("Employee record inserted successfully with id: " + generatedId + " and name: " + name);
                }
            } else {
                System.out.println("Failed to insert employee record.");
            }

            // Close the resources
            preparedStatement.close();
            connection.close();
            scanner.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
