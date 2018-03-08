package assignment_3;

public abstract class Employee {
	private String employeeName;
	private int employeeId;
	private boolean isWorking;
	
	public Employee(){
		
	}

	public Employee(String name, String number, String employed) {
		employeeName = name;
		employeeId = Integer.parseInt(number);
		isWorking = Boolean.parseBoolean(employed);
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public boolean isWorking() {
		return isWorking;
	}

	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}

	public abstract double getPay();

	@Override
	public String toString() {
		return  getEmployeeName() + "\t" + getEmployeeId() + "\t" + isWorking() + "\t";
	}

}
