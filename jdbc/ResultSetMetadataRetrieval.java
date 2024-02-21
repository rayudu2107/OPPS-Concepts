package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetadataRetrieval {
	public static void main(String[] args) {
		Connection connection = DBSingleton.getConnection(); // Using singleton instance

		try {
			String query = "SELECT * FROM empdb.employee";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			ResultSetMetaData metaData = resultSet.getMetaData(); // Getting ResultSetMetaData from the resultSet

			// Printing column names and types
			int columnCount = metaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				String columnName = metaData.getColumnName(i);
				String columnType = metaData.getColumnTypeName(i);
				System.out.println("Column Name: " + columnName + ", Column Type: " + columnType);
				System.out.println("---------------------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
