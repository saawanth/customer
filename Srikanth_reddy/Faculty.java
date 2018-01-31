package assign3;

public class Faculty extends Employee {
	
	double annualSalary;
	int weeksPerYear;
	String department;
	
	
	

	public Faculty(String name, String number, String employed, String annualSalary, String weeksPerYear, String department) {
		super(name, number, employed);
		this.annualSalary= Double.parseDouble(annualSalary);
		this.weeksPerYear=Integer.parseInt(weeksPerYear);
		this.department=department;
		
		// TODO Auto-generated constructor stub
	}
	
	

	public double getAnnualSalary() {
		return annualSalary;
	}



	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}



	public int getWeeksPerYear() {
		return weeksPerYear;
	}



	public void setWeeksPerYear(int weeksPerYear) {
		this.weeksPerYear = weeksPerYear;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}

	

	@Override
	public String toString() {
		return super.getEmployeeName()+"\t\t\t"+ super.getEmployeeId()+"\t\t"+super.isWorking()+"\t\t"+annualSalary +"\t\t"+ weeksPerYear+ "\t\t"+ department ;
	}
	



	@Override
	public double getPay() {
		// TODO Auto-generated method stub
		return ((2 * annualSalary) + weeksPerYear);
	}



	

}
