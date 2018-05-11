package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class JdbcSql {

	public static void main(String args[]) throws ClassNotFoundException {

		String url = "jdbc:mysql://localhost:3306/raghu1";
		String username = "root";
		String password = "Raghu@0462";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection;

		System.out.println("Connecting database...");
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Database connected!");
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM physician");
			result = stmt.executeQuery();
			while (result.next()) {
				System.out.println(result.getInt(1));
				System.out.println(result.getString(2));
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}

		try {
			connection.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}
