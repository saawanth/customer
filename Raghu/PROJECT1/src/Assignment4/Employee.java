package Assignment4;

public abstract class Employee {

	String employeename;
	int employeeid;
	boolean isWorking;
	
	
	public Employee(String employeename, String employeeid, String isWorking) {
		this.employeename = employeename;
		this.employeeid = Integer.parseInt(employeeid);
		this.isWorking = Boolean.parseBoolean(isWorking);
	}

	public String getEmployeename() {
		return employeename;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public boolean isWorking() {
		return isWorking;
	}

	@Override
	public String toString() {
		return "Employee employeename=" + employeename + "employeeid=" + employeeid + "isWorking=" + isWorking;
	}

	public abstract double getPay();

}
