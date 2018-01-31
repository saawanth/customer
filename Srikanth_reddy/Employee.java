package assign3;

public abstract class Employee {
	
	private String employeeName;
	private int employeeId;
	private boolean isWorking;
	
	
	//Constructor
	public Employee(String name, String number, String employed) {
		this.employeeName = name;
		this.employeeId = Integer.parseInt(number);
		this.isWorking = Boolean.parseBoolean(employed);
	}
	
	//getter and setter methods
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

	@Override
	public String toString() {
		return employeeName +""+ employeeId +""+ isWorking;
	}
	
	//mandatory abstract method
	public abstract double getPay();
	
}