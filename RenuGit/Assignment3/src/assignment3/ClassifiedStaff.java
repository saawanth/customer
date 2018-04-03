package assignment3;

public class ClassifiedStaff extends Employee{

	private double weeklySalary;
	private String division;
	
	public ClassifiedStaff(String name, String number, String employed, String salary, String div) {
		super(name, number, employed);
		this.weeklySalary = Double.parseDouble(salary);
		this.division = div;
	}

	@Override
	public double getPay() {
		return 2 * weeklySalary;
	}

	@Override
	public String toString() {
		return getEmployeeName() +"\t"+ getEmployeeID() + "\t" + isWorking() + "\t" + weeklySalary + "\t" + division;
	}
	
}
