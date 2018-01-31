
public class StudentEmployee extends Employee {
	int hoursWorked;
	String isworkStudy;
	double payRate;

	
	public StudentEmployee(String Name,String Number,String Working,String Hours,String IsworkStudy,String PayRate) {
		super(Name,Number,Working);
		this.hoursWorked=Integer.parseInt(Hours);
		this.payRate=Double.parseDouble(PayRate);
		this.isworkStudy=IsworkStudy;
		
	}
	


	@Override
	public String toString() {
		return employeename + "\t" + employeeid + "\t" + isWorking + "\t" + this.hoursWorked
				+ "\t" + this.isworkStudy + "\t" + this.payRate;
	}
	
	public double getPay() {
if(isWorking) {
		payRate=(hoursWorked*payRate);
		payRate=Math.round(payRate);
}
		return payRate;
	}

	
	
	//Cathy KaufStan Stanley,123456789,TRUE,19,FALSE,10.95
}
