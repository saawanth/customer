package com.renujdbc;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class jdbc {

	public static void main(String[] args) throws FileNotFoundException {
		String url = "jdbc:postgresql://localhost:5432/JDBCAssignment";
		String name = "postgres";
		String password = "renu";
		String query = "create table Employee" + "(eID varchar(10) PRIMARY KEY," + "firstName varchar(30),"
				+ "lastName varchar(30))";

		Scanner sc = new Scanner(new File("C:/Users/renuk/Desktop/Renu Training/jdbcrenu/Employees.csv"));

		try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection con = DriverManager.getConnection(url, name, password);
			Statement pst = con.createStatement();
			DatabaseMetaData dbm = con.getMetaData();
			ResultSet rt = dbm.getTables(null, null, "employee", null);
			if (rt.next()) {
				pst.executeUpdate("DROP TABLE employee;");
			}
			pst.executeUpdate(query);
			System.out.println("Created table in the database");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] arr = line.split(",");
				String id = arr[0];
				String fName = arr[1];
				String lName = arr[2];
				String query2 = "";
				query2 = "INSERT INTO employee (eid,firstName,lastName)" + "VALUES('" + id + "','" + fName + "','"
						+ lName + "')";
				pst.executeUpdate(query2);

			}
			ResultSet rs1 = pst.executeQuery("SELECT * FROM employee;");
			while (rs1.next()) {
				System.out.println(rs1.getString(1) + " " + rs1.getString(2) + " " + rs1.getString(3));
			}
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
