package task.fetchemployeedetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee {

	public static void main(String[] args) {
		// Prompt the user to enter employee ID
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter employee ID: ");
		int employeeID = scanner.nextInt();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// Step 1: Load and register the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Establish connection to the database
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdatabase", "root", "root");

			// Step 3: Create a PreparedStatement with parameterized query
			String query = "SELECT * FROM employee WHERE employee_id = ?";
			preparedStatement = connection.prepareStatement(query);

			// Step 4: Set the parameter value
			preparedStatement.setInt(1, employeeID);

			// Step 5: Execute the query
			resultSet = preparedStatement.executeQuery();

			// Step 6: Process the result set
			if (resultSet.next()) {
				// Retrieve employee details
				String name = resultSet.getString("employee_name");
				int age = resultSet.getInt("employee_age");
				String department = resultSet.getString("department");
				double salary = resultSet.getDouble("employee_salary");

				// Display employee information
				System.out.println("Employee ID: " + employeeID);
				System.out.println("Name: " + name);
				System.out.println("Age: " + age);
				System.out.println("Department: " + department);
				System.out.println("Salary: " + salary);
			} else {
				System.out.println("Employee not found with ID: " + employeeID);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load JDBC driver: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error executing SQL query: " + e.getMessage());
		} finally {
			try {
				// Step 7: Close JDBC resources in the finally block
				connection.close();
				preparedStatement.close();
				resultSet.close();
				scanner.close();
			} catch (SQLException e) {
				System.out.println("Error closing resources: " + e.getMessage());
			}
		}
	}
}
