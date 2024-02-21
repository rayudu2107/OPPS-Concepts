package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSingleton {
	private static Connection c=null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				c=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
		} catch (ClassNotFoundException e) {
			System.out.println("DBSingleton:static-black:DriverClass not found");
		}
		catch (SQLException e) {
			System.out.println("DBSingleton:static-black:Connection  not established");
			System.out.println(e.getSQLState());
		}
	}
	public static Connection getConnection() {
		return c;
	}
}
