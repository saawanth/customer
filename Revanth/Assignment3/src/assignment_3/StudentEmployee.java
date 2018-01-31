package assignment_3;

public class StudentEmployee extends Employee {
	private int hoursWorked;
	private boolean isWorkStudy;
	private double payRate;

	// public StudentEmployee(){
	// super();
	// }

	public StudentEmployee(String name, String number, String working, String hours, String workstudy, String rate) {
		super(name, number, working);
		hoursWorked = Integer.parseInt(hours);
		isWorkStudy = Boolean.parseBoolean(workstudy);
		payRate = Double.parseDouble(rate);

	}

	@Override
	public double getPay() {
		// TODO Auto-generated method stub
		return hoursWorked*payRate;
	}

	@Override
	public String toString() {
		return super.toString() + "\t" + hoursWorked + "\t" + isWorkStudy + "\t" + payRate;

	}
}
