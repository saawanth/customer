package assignment3;

public abstract class Employee {

	private String employeeName;
	private int employeeID;
	private boolean isWorking;

	public abstract double getPay();

	public Employee(String name, String number, String employed) {
		super();
		this.employeeName = name;
		this.employeeID = Integer.parseInt(number);
		this.isWorking = Boolean.parseBoolean(employed);
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public boolean isWorking() {
		return isWorking;
	}

	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}

	@Override
	public String toString() {
		return  employeeName +"\t"+ employeeID + "\t" + isWorking;
	}

}
