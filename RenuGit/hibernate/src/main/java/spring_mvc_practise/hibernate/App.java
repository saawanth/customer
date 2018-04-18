package spring_mvc_practise.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String username = "hbstudent";
		String password = "hbstudent";

		System.out.println("Connecting to Database: " + url);

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection successful");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
