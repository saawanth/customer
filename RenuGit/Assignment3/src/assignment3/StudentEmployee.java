package assignment3;

public class StudentEmployee extends Employee{

	private int hoursWorked;
	private boolean isWorkStudy;
	private double payRate;
	
	public StudentEmployee(String name, String number, String employed, String hours, String workstudy, String rate) {
		super(name, number, employed);
		this.hoursWorked = Integer.parseInt(hours);
		this.isWorkStudy = Boolean.parseBoolean(workstudy);
		this.payRate = Double.parseDouble(rate);
	}

	@Override
	public double getPay() {
		if(isWorkStudy == true){
			return hoursWorked * payRate;
		}
		else{
			return 0.0;
		}
	}

	@Override
	public String toString() {
		return getEmployeeName() +"\t"+ getEmployeeID() + "\t" + isWorking() + "\t" + hoursWorked + "\t" + isWorkStudy + "\t" + payRate;
	}	
	
}
