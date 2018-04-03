package assignment3;

public class Faculty extends Employee {

	private double annualSalary;
	private int weeksPerYear;
	private String department;

	public Faculty(String name, String number, String employed, String salary, String weeks,
			String dept) {
		super(name, number, employed);
		this.annualSalary = Double.parseDouble(salary);
		this.weeksPerYear = Integer.parseInt(weeks);
		this.department = dept;
	}

	@Override
	public double getPay() {
		return (2 * (annualSalary / weeksPerYear));
	}

	@Override
	public String toString() {
		return getEmployeeName() +"\t"+ getEmployeeID() + "\t" + isWorking() + "\t" + annualSalary + "\t" + weeksPerYear + "\t" + department;
	}

}
