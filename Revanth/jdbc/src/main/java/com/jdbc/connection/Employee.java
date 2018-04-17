package com.jdbc.connection;

public class Employee {
	private int empID;
	private String fName;
	private String lName;

	public Employee(int empID, String fName, String lName) {
		this.empID = empID;
		this.fName = fName;
		this.lName = lName;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

}
