package assign3;

public class ClassifiedStaff extends Employee {
	
	double weeklySalary;
	String division;

	public ClassifiedStaff(String name, String number, String working,String weeklySalary, String div) {
		super(name, number, working);
		// TODO Auto-generated constructor stub
		this.weeklySalary=Double.parseDouble(weeklySalary);
		this.division=div;		
	}
	
	

	public double getWeeklySalary() {
		return weeklySalary;
	}



	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}



	public String getDivision() {
		return division;
	}



	public void setDivision(String division) {
		this.division = division;
	}
	
	

	@Override
	public String toString() {
		return super.getEmployeeName()+"\t\t\t"+ super.getEmployeeId()+"\t\t"+super.isWorking()+"\t\t"+weeklySalary + "\t\t" + division;
	}



	@Override
	public double getPay() {
		// TODO Auto-generated method stub
		return (2 * weeklySalary);
	}

}
