package assign3;

public class StudentEmployee extends Employee {
	
	int hoursWorked;
	boolean isWorkStudy;
	double payRate;

	public StudentEmployee(String name, String number, String employed, String hoursWorked, String isWorkStudy,String payRate) {
		super(name, number, employed);
		this.hoursWorked = Integer.parseInt(hoursWorked);
		this.isWorkStudy = Boolean.parseBoolean(isWorkStudy);
		this.payRate = Double.parseDouble(payRate);
	}
	
	
	
	public int getHoursWorked() {
		return hoursWorked;
	}



	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}



	public boolean isWorkStudy() {
		return isWorkStudy;
	}



	public void setWorkStudy(boolean isWorkStudy) {
		this.isWorkStudy = isWorkStudy;
	}



	public double getPayRate() {
		return payRate;
	}



	public void setPayRate(double payRate) {
		this.payRate = payRate;
		}

	

	@Override
	public String toString() {
		return super.getEmployeeName()+"\t\t\t"+ super.getEmployeeId()+"\t\t"+super.isWorking()+"\t\t"+hoursWorked +"\t\t"+  isWorkStudy +"\t\t"+ payRate;
		
	}



	@Override
	public double getPay() {
		// TODO Auto-generated method stub
		double pay=this.hoursWorked * this.payRate;
		return pay;
	}

}
