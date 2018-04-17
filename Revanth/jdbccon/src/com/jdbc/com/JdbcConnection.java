package com.jdbc.com;

import java.sql.*;

public class JdbcConnection {
	public static void main(String args[]) {
		String url = "jdbc:postgresql://localhost:5432/Employees";
		String uName = "postgres";

		try {
			
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, uName, "reva");
			Statement st = con.createStatement();
		
			ResultSet rs = st.executeQuery("select * from Movies");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
