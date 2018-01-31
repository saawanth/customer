
public class Faculty extends Employee {
	double annualsalary;
	int weeksPerYear;
	String department;
	
	
	
	public Faculty(String name, String number, String working, String annualsalary, String weeksPerYear, String department) {
		super(name,number,working);
		this.annualsalary = Double.parseDouble(annualsalary);
		this.weeksPerYear = Integer.parseInt(weeksPerYear);
		this.department = department;
	}
	@Override
	public String toString() {
		return employeename + "\t" + employeeid + "\t" + isWorking + "\t" + annualsalary
				+ "\t" + weeksPerYear + "\t" + department;
	}
	public double getPay() {
		if(isWorking) {
		annualsalary=(annualsalary/weeksPerYear)*2;
		annualsalary=Math.round(annualsalary);
		}
		return annualsalary;
	}
	
	
	
	
}
//Jim Harper,336699866,FALSE,63221,36,Math