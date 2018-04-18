package assignment3;

public class ClassifiedStaff extends Employee {
	/*private double weeklySalary;
	private String division;
	
	public ClassifiedStaff() {
		
	}
    public ClassifiedStaff(double weeklySalary, String division) {
    	this.weeklySalary = weeklySalary;
		this.division = division;
	}
	
	public ClassifiedStaff(String employeeName, int employeeId, boolean working, double weeklySalary, String division) {
		super(employeeName, employeeId, working);
		this.weeklySalary = weeklySalary;
		this.division = division;
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
		return "ClassifiedStaff [weeklySalary=" + weeklySalary + ", division=" + division + "]";
	}


	@Override
	public double getPay() {
		// TODO Auto-generated method stub
		System.out.println("I'm getPay form ClassifiedStaff");
		return 0;
	}*/
	 //private fields
	   private double weeklySalary;
	   private String division;
	   
	   //constructor
	   public ClassifiedStaff(String name, String number, String working,
	      String salary, String div) {
	      
	      //call superclass constructor
	      super(name, number, working);
	      
	      //move remaining data into private fields
	      weeklySalary = Double.parseDouble(salary);
	      division = div;
	   }
	   
	   //getPay returns weeklySalary times two
	   public double getPay() {
	      return weeklySalary * 2;
	   }
	   
	   //toString returns object attributes
	   public String toString() {
	      return super.toString() + "\t" + weeklySalary + "\t" + division;
	   }
    
}
