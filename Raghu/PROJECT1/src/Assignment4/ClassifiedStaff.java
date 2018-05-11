package Assignment4;

public class ClassifiedStaff extends Employee {

	String division;
	double weeklySalary;

	public ClassifiedStaff(String name, String number, String working, String weeklySalary, String division) {
		super(name, number, working);
		this.division = division;
		this.weeklySalary = Double.parseDouble(weeklySalary);
	}

	@Override
	public String toString() {
		return employeename + "\t" + employeeid + "\t" + isWorking + "\t" + weeklySalary + "\t" + division;
	}

	public double getPay() {
		if (isWorking) {
			weeklySalary = weeklySalary * 2;
		}
		return weeklySalary;
	}

}
