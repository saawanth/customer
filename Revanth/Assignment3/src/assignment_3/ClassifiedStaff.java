package assignment_3;

public class ClassifiedStaff extends Employee {
	private double weeklySalary;
	private String division;

	public ClassifiedStaff(){
		super();
	}
	
	public ClassifiedStaff(String name, String number, String working, String salary, String div) {
		// TODO Auto-generated constructor stub
		super(name, number, working);
		weeklySalary = Double.parseDouble(salary);
		division = div;
	}

	@Override
	public double getPay() {
		// TODO Auto-generated method stub
		return weeklySalary*2;
	}

	@Override
	public String toString() {
		return super.toString() + "\t" + weeklySalary + "\t" + division;
	}

}
