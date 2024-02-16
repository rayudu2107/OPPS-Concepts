package task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ResultSetMetadataRetrieval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String url, username, password;

            // Prompt the user to input database URL, username, and password
            while (true) {
                System.out.println("Enter database URL:");
                url = scanner.nextLine();
                if (!url.isEmpty()) {
                    break;
                }
                System.out.println("URL cannot be empty. Please try again.");
            }

            while (true) {
                System.out.println("Enter username:");
                username = scanner.nextLine();
                if (!username.isEmpty()) {
                    break;
                }
                System.out.println("Username cannot be empty. Please try again.");
            }

            while (true) {
                System.out.println("Enter password:");
                password = scanner.nextLine();
                if (!password.isEmpty()) {
                    break;
                }
                System.out.println("Password cannot be empty. Please try again.");
            }
            System.out.println();

            // Establish connection to the database using user input
            connection = DriverManager.getConnection(url, username, password);

         // Prompt the user to input table name
            System.out.println("Enter table name:");
            String tableName = scanner.nextLine();

            // Create a PreparedStatement with query
            String query = "SELECT * FROM " + tableName;
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            // Get ResultSet metadata
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Display metadata details
            System.out.println("Metadata Details:");
            System.out.println("Number of Columns: " + columnCount);
            System.out.println("Column Details:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column Name: " + metaData.getColumnName(i));
                System.out.println("Data Type: " + metaData.getColumnTypeName(i));
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the resources in a finally block
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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
