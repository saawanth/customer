package ass1;

public class ClassifiedStaff extends Employee {
double weeklySalary;
String division;


ClassifiedStaff(String name, String number, String working, String salary, String div){
	super(name, number, working);
	this.division=div;
	this.weeklySalary=Double.parseDouble(salary);
	
}

@Override
public String toString() {
	return (   empName + " " + empId + " " + isWorking + " " + weeklySalary + " " + division );
}

public double getpay(){
	return (2*weeklySalary);
}
} 