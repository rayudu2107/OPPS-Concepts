package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeUsingPstmtDao {
    private Connection connection;
    private Scanner scanner;

    public EmployeeUsingPstmtDao(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void insertEmployee() {
        try {
            int id = validateIntInput("Enter employee ID: ", "Invalid input. Please enter a valid employee ID.");

            if (isEmployeeExists(id)) {
                System.out.println("An employee with ID " + id + " already exists. Please choose a different ID.");
                return;
            }

            String name = validateStringInput("Enter name:", "Name cannot be empty. Please enter a valid name.");
            double salary = validateDoubleInput("Enter employee salary: ", "Invalid input. Please enter a valid employee salary");
            String designation = validateStringInput("Enter employee designation: ", "Invalid input. Please enter a valid employee designation");
            String location = validateStringInput("Enter employee location:", "Location cannot be empty. Please enter a valid location");

            String query = "INSERT INTO employee (id, name, salary, Des, Loc) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setDouble(3, salary);
            preparedStatement.setString(4, designation);
            preparedStatement.setString(5, location);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee inserted successfully.");
            } else {
                System.out.println("Failed to insert employee.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }

    private double validateDoubleInput(String prompt, String errorMessage) {
        System.out.println(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println(errorMessage);
            scanner.next(); // Consume invalid input
        }
        return scanner.nextDouble();
    }

    private int validateIntInput(String prompt, String errorMessage) {
        System.out.println(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println(errorMessage);
            scanner.next(); // Consume invalid input
        }
        return scanner.nextInt();
    }

    private String validateStringInput(String prompt, String errorMessage) {
        scanner.nextLine(); // Consume newline character
        System.out.println(prompt);
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.println(errorMessage);
            input = scanner.nextLine().trim();
        }
        return input;
    }

    private boolean isEmployeeExists(int id) {
        try {
            String query = "SELECT * FROM employee WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
        return false;
    }
    
    public void getEmployeeById() {
        try {
            int id = validateIntInput("Enter employee ID: ", "Invalid input. Please enter a valid employee ID.");

            String query = "SELECT * FROM employee WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Print table header
            System.out.println("ID\tName\tSalary\tDesignation\tLocation");

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                String designation = resultSet.getString("Des");
                String location = resultSet.getString("Loc");
                System.out.println(id + "\t" + name + "\t" + salary + "\t" + designation + "\t" + location);
            } else {
                System.out.println("No Records Found for ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }

    public void deleteEmployeeById() {
        try {
            int id = validateIntInput("Enter employee ID: ", "Invalid input. Please enter a valid employee ID.");

            String query = "DELETE FROM employee WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            int norowaffected = preparedStatement.executeUpdate();
            if (norowaffected > 0) {
                System.out.println("Employee with ID " + id + " deleted successfully.");
            } else {
                System.out.println("No employee found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }

    public void updateEmployeeById() {
        try {
            int id = validateIntInput("Enter employee ID: ", "Invalid input. Please enter a valid employee ID.");

            String querySelect = "SELECT * FROM employee WHERE id = ?";
            PreparedStatement preparedStatementSelect = connection.prepareStatement(querySelect);
            preparedStatementSelect.setInt(1, id);
            ResultSet resultSet = preparedStatementSelect.executeQuery();

            if (!resultSet.next()) {
                System.out.println("No employee found with ID: " + id);
                return; // Exit the method if employee not found
            }

            scanner.nextLine(); // Consume newline character

            System.out.print("Enter new name: ");
            String name = validateStringInput("", "Invalid input. Please enter a valid name.");
            double salary = validateDoubleInput("Enter new salary: ", "Invalid input. Please enter a valid salary.");
            String designation = validateStringInput("Enter new designation: ", "Invalid input. Please enter a valid designation.");
            String location = validateStringInput("Enter new location: ", "Invalid input. Please enter a valid location.");

            String queryUpdate = "UPDATE employee SET name = ?, salary = ?, Des = ?, Loc = ? WHERE id = ?";
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(queryUpdate);
            preparedStatementUpdate.setString(1, name);
            preparedStatementUpdate.setDouble(2, salary);
            preparedStatementUpdate.setString(3, designation);
            preparedStatementUpdate.setString(4, location);
            preparedStatementUpdate.setInt(5, id);

            int norowaffected = preparedStatementUpdate.executeUpdate();
            if (norowaffected > 0) {
                System.out.println("Employee with ID " + id + " updated successfully.");
            } else {
                System.out.println("No employee found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }
    public void getAllEmployees() {
        try {
            String query = "SELECT * FROM employee";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
           
            // Print table header
            System.out.println("ID\tName\tSalary\tDesignation\tLocation");
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                String designation = resultSet.getString("Des");
                String location = resultSet.getString("Loc");
                System.out.println(id + "\t" + name + "\t" + salary + "\t" + designation + "\t" + location);
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }
    
}

