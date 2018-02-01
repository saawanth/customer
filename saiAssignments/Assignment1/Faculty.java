package ass1;

public class Faculty extends Employee{
	
	double annualSalary;
	String department;
	int WeeksPerYear;
	
	Faculty(String name, String number, String working, String salary, String weeks, String dept){
		super(name,number,working);
		this.annualSalary=Double.parseDouble(salary);
		this.department=dept;
		this.WeeksPerYear=Integer.parseInt(weeks);
		
	}
	
	@Override
	public String toString() {
		return ( empName + " " + empId + " " + isWorking  + " " + annualSalary + " " + department + " " + WeeksPerYear);
	}

	public double getpay(){
		double valueRounded = Math.round((annualSalary*2/WeeksPerYear) * 100D) / 100D;
		return valueRounded;
	}
	
}
