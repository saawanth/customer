package assignment3;

public class Faculty extends Employee {
	/*private double annualSalary;
	private int weeksPerYear;
	private String department;
    public Faculty() {
    	
    }
    public Faculty( double annualSalary, int weeksPerYear, String department) {
    	this.annualSalary = annualSalary;
		this.weeksPerYear = weeksPerYear;
		this.department = department;
    }
	public Faculty(String employeeName, int employeeId, boolean working, double annualSalary, int weeksPerYear,
			String department) {
		super(employeeName, employeeId, working);
		this.annualSalary = annualSalary;
		this.weeksPerYear = weeksPerYear;
		this.department = department;
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
		return "Faculty [annualSalary=" + annualSalary + ", weeksPerYear=" + weeksPerYear + ", department=" + department
				+ "]";
	}

	@Override
	public double getPay() {
		// TODO Auto-generated method stub
		System.out.println("I'm getPay form Faculty");
		return 0;
	}*/
	 //private fields
	   private double annualSalary;
	   private int weeksPerYear;
	   private String department;
	   
	   //constructor
	   public Faculty (String name, String number, String working,
	      String salary, String weeks, String dept) {
	      
	      //call superclass constructor
	      super(name, number, working);
	      
	      //move remaining data into private fields
	      annualSalary = Double.parseDouble(salary);
	      weeksPerYear = Integer.parseInt(weeks);
	      department = dept;
	   }
	   
	   // toString returns object attributes
	   public String toString() {
	      return super.toString() + "\t" + annualSalary + "\t" +
	         weeksPerYear + "\t" + department;
	   }
	   
	   // getPay returns total pay
	   public double getPay() {
		   if (isWorking) {
				annualSalary = (annualSalary / weeksPerYear) * 2;
			}
			return annualSalary;
	   }
}
