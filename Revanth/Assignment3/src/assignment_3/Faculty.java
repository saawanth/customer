package assignment_3;

public class Faculty extends Employee {
	private double annualSalary;
	private int weeksPerYear;
	private String department;

	public Faculty() {
		super();
	}

	public Faculty(String name, String number, String working, String salary, String weeks, String dept) {
		super(name, number, working);
		annualSalary = Double.parseDouble(salary);
		weeksPerYear = Integer.parseInt(weeks);
		department = dept;

	}

	@Override
	public double getPay() {
		// TODO Auto-generated method stub
//		System.out.println("Annual salary: " + annualSalary);
//		System.out.println("WeeksperYear: " + weeksPerYear);
//		System.out.println((annualSalary * 2) / weeksPerYear);
		return (annualSalary * 2) / weeksPerYear;
	}

	@Override
	public String toString() {
		return super.toString() + "\t" + annualSalary + "\t" + weeksPerYear + "\t" + department;

	}

}
