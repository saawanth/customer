package ass1;

public class StudentEmployee extends Employee{
int hoursWorked;
boolean isWorkStudy;
double payRate;

StudentEmployee(String name, String number, String working, String hours, String workstudy, String rate){
	super(name,number,working);
	this.hoursWorked=Integer.parseInt(hours);
	this.isWorkStudy=Boolean.parseBoolean(workstudy);
	this.payRate=Double.parseDouble(rate);
	
}

@Override
public String toString() {
	return (  empName+"	" + empId+" " + isWorking+" "+ hoursWorked+" " + isWorkStudy+" " + payRate);
}

public double getpay(){
	double valueRounded = Math.round((hoursWorked*payRate) * 100D) / 100D;
	return valueRounded;
}
}
