package com.jdbc.connection;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcConnectivity {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String url = "jdbc:postgresql://localhost:5432/Employees";
		String uName = "postgres";
		String pswd = "reva";
		String query1 = "CREATE TABLE employees(empid int PRIMARY KEY, fname VARCHAR(20), lname VARCHAR(20));";
		File file = new File("C:/Users/revan/Desktop/Files/Employees.csv");
		Scanner scan = new Scanner(file);
		Employee[] employee = new Employee[9];
		int i = 0;
		String god = scan.nextLine();
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] str = line.split(",");
			employee[i++] = new Employee(Integer.parseInt(str[0]), str[1], str[2]);
		}
		scan.close();

		try {
			Class.forName("org.postgresql.Driver");
			
			System.out.println("Connecting to a selected database...");
			Connection con = DriverManager.getConnection(url, uName, pswd);
			System.out.println("Connected database successfully...");

			Statement st = con.createStatement();
			DatabaseMetaData dbm = con.getMetaData();
			// check if "employee" table is there
			ResultSet tables = dbm.getTables(null, null, "employees", null);
			if (tables.next()) {
				// Table exists
				st.executeUpdate("DROP TABLE employees;");
			}

			st.executeUpdate(query1);

			for (int j = 0; j < employee.length; j++) {
				st.executeUpdate("INSERT INTO employees (empid, fname, lname) " + "VALUES( " + employee[j].getEmpID()
						+ ", '" + employee[j].getfName() + "' , '" + employee[j].getlName() + "');");
			}
			ResultSet rs = st.executeQuery("SELECT * " + "FROM employees;");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
