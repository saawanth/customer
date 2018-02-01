package ass1;

public abstract class Employee {


	public abstract double getpay();
	String empName;
	int empId;
	boolean isWorking;
	
	public Employee(String name,String number,String working)
	{
		this.empId=Integer.parseInt(number);
		this.empName=name;
		this.isWorking=Boolean.parseBoolean(working);
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public boolean isWorking() {
		return isWorking;
	}

	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}
	
}
		


