package Jdbc1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class scannerclass {

	public static void main(String args[]) throws FileNotFoundException {
		String fileNameDefined = "/Users/raghu/employeejdbc.csv";
		File file = new File(fileNameDefined);
		Statement statement = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/raghu2" , "root" , "Raghu@0462");

			statement = con.createStatement();

			statement.executeUpdate("CREATE TABLE IF NOT EXISTS "
					+ " employees(empid int(10) PRIMARY KEY,firstname varchar(20),lastname varchar(20))");
			
			System.out.println("Table Created");
		}
			
			catch (SQLException e) {
				System.out.println("An error has occurred on Table Creation");
			}
		try {
			Scanner sc = new Scanner(new FileReader(file));

			while (sc.hasNext()) {
				String str[] = sc.nextLine().split(",");
				String id = str[0];
				String fName = str[1];
				String lName = str[2];
				String query = "INSERT INTO employees(empid,firstname,lastname) " + "VALUES('" + id + "','"
						+ fName + "','" + lName + "')";

					statement.executeUpdate(query);
				} 
			} catch (SQLException e) {
					e.printStackTrace();
				}

	}

}
