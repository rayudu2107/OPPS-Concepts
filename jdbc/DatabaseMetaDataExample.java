package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class DatabaseMetaDataExample {
	public static void main(String[] args) {
		Connection connection = DBSingleton.getConnection();
		try {
			DatabaseMetaData dbMeta = connection.getMetaData();

			// Get information about the database product
			
			String dbProductName = dbMeta.getDatabaseProductName();
			int dbMajorVersion = dbMeta.getDatabaseMajorVersion();
			int dbMinorVersion = dbMeta.getDatabaseMinorVersion();
			System.out.println("Database Product Name: " + dbProductName);
			System.out.println("Database Version: " + dbMajorVersion + "." + dbMinorVersion);

			// Get information about the JDBC driver
			
			String driverName = dbMeta.getDriverName();
			String driverVersion = dbMeta.getDriverVersion();
			System.out.println("JDBC Driver Name: " + driverName);
			System.out.println("JDBC Driver Version: " + driverVersion);

			// Get information about the maximum lengths for various objects
			
			int maxColumnNameLength = dbMeta.getMaxColumnNameLength();
			int maxColumnsInTable = dbMeta.getMaxColumnsInTable();
			int maxTableNameLength = dbMeta.getMaxTableNameLength();
			System.out.println("Max Column Name Length: " + maxColumnNameLength);
			System.out.println("Max Columns In Table: " + maxColumnsInTable);
			System.out.println("Max Table Name Length: " + maxTableNameLength);

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
