package task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeDatabaseApplication {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String url = getUserInput(scanner, "Enter database URL:", "URL cannot be empty.");
			String username = getUserInput(scanner, "Enter username:", "Username cannot be empty.");
			String password = getUserInput(scanner, "Enter password:", "Password cannot be empty.");
			String tableName = getUserInput(scanner, "Enter table name:", "Table name cannot be empty.");

			try (Connection connection = DriverManager.getConnection(url, username, password)) {
				while (true) {
					try {
						System.out.println("Choose an option:");
						System.out.println("1. Insert new record");
						System.out.println("2. Update existing record");
						System.out.println("3. View all employees");
						System.out.println("4. Exit");
						int option = scanner.nextInt();

						switch (option) {
							case 1:
								insertRecord(connection, scanner, tableName);
								break;
							case 2:
								updateRecord(connection, scanner, tableName);
								break;
							case 3:
								getAllEmployees(connection, tableName);
								break;
							case 4:
								System.out.println("Exiting...");
								return;
							default:
								System.out.println("Invalid option. Please choose again.");
						}
					} catch (InputMismatchException e) {
						System.out.println("Invalid input. Please enter a valid menu option (1-4).");
						scanner.nextLine(); // Consume the invalid input
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("Error executing SQL query: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
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

	private static void insertRecord(Connection connection, Scanner scanner, String tableName) throws SQLException {
		int employee_id = getValidIntegerInput(scanner, "Enter employee ID:",
				"Invalid input. Please enter a valid employee ID.");
		if (employeeExists(connection, tableName, employee_id)) {
			System.out.println("Employee ID already registered: " + employee_id);
			return;
		}

		String employee_name = getUserInput(scanner, "Enter name:", "Name cannot be empty. Please enter a valid name.");
		int employee_age = getValidIntegerInput(scanner, "Enter age:",
				"Invalid age. Please provide an age between 0 and 150.");
		String department = getUserInput(scanner, "Enter department:",
				"Department cannot be empty. Please enter a valid department.");
		double employee_salary = getPositiveDoubleInput(scanner, "Enter salary:",
				"Invalid salary. Please provide a positive value.");

		String query = "INSERT INTO " + tableName
				+ " (employee_id, employee_name, employee_age, department, employee_salary) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, employee_id);
			preparedStatement.setString(2, employee_name);
			preparedStatement.setInt(3, employee_age);
			preparedStatement.setString(4, department);
			preparedStatement.setDouble(5, employee_salary);

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Employee inserted successfully.");
			} else {
				System.out.println("Failed to insert employee.");
			}
		}
	}

	private static int getValidIntegerInput(Scanner scanner, String prompt, String errorMessage) {
		while (true) {
			System.out.println(prompt);
			try {
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(errorMessage);
				scanner.nextLine(); // Consume the invalid input
			}
		}
	}

	private static double getPositiveDoubleInput(Scanner scanner, String prompt, String errorMessage) {
		while (true) {
			System.out.println(prompt);
			try {
				double value = scanner.nextDouble();
				if (value > 0) {
					return value;
				}
				System.out.println(errorMessage);
			} catch (InputMismatchException e) {
				System.out.println(errorMessage);
				scanner.nextLine(); // Consume the invalid input
			}
		}
	}

	private static void updateRecord(Connection connection, Scanner scanner, String tableName) throws SQLException {
		int employeeID = getValidIntegerInput(scanner, "Enter employee ID to update:",
				"Invalid input. Please enter a valid employee ID.");
		if (!employeeExists(connection, tableName, employeeID)) {
			System.out.println("No employee found with ID: " + employeeID);
			return;
		}

		String newName = getUserInput(scanner, "Enter new name:", "Name cannot be empty. Please enter a valid name.");
		int newAge = getValidIntegerInput(scanner, "Enter new age:",
				"Invalid age. Please provide an age between 0 and 150.");
		String newDepartment = getUserInput(scanner, "Enter new department:",
				"Department cannot be empty. Please enter a valid department.");
		double newSalary = getPositiveDoubleInput(scanner, "Enter new salary:",
				"Invalid salary. Please provide a positive value.");

		String query = "UPDATE " + tableName
				+ " SET employee_name = ?, employee_age = ?, department = ?, employee_salary = ? WHERE employee_id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, newName);
			preparedStatement.setInt(2, newAge);
			preparedStatement.setString(3, newDepartment);
			preparedStatement.setDouble(4, newSalary);
			preparedStatement.setInt(5, employeeID);

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Employee with ID " + employeeID + " updated successfully.");
			} else {
				System.out.println("Failed to update employee.");
			}
		}
	}

	private static boolean employeeExists(Connection connection, String tableName, int employeeID) throws SQLException {
		String query = "SELECT * FROM " + tableName + " WHERE employee_id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, employeeID);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				return resultSet.next();
			}
		}
	}

	private static void getAllEmployees(Connection connection, String tableName) throws SQLException {
		String query = "SELECT * FROM " + tableName;
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			System.out.println("EmployeeID\tName\tAge\tDepartment\tSalary");
			while (resultSet.next()) {
				int employeeID = resultSet.getInt("employee_id");
				String name = resultSet.getString("employee_name");
				int age = resultSet.getInt("employee_age");
				String department = resultSet.getString("department");
				double salary = resultSet.getDouble("employee_salary");
				System.out.println(employeeID + "\t\t" + name + "\t" + age + "\t" + department + "\t\t" + salary);
			}
		}
	}
}
