package assignment3;

public class StudentEmployee extends Employee {
	
	
	 /* private int hoursWorked;
      private boolean WorkStudy;
      private boolean payRate;
      public StudentEmployee() {
  		
  	  }
      public StudentEmployee(int hoursWorked, boolean workStudy, boolean payRate) {
  		this.hoursWorked = hoursWorked;
  		WorkStudy = workStudy;
  		this.payRate = payRate;
  	}
      public StudentEmployee(String employeeName, int employeeId, boolean working, int hoursWorked, boolean workStudy,
			boolean payRate) {
		super(employeeName, employeeId, working);
		this.hoursWorked = hoursWorked;
		WorkStudy = workStudy;
		this.payRate = payRate;
	}
    

	public int getHoursWorked() {
		return hoursWorked;
	}


	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}


	public boolean isWorkStudy() {
		return WorkStudy;
	}


	public void setWorkStudy(boolean workStudy) {
		WorkStudy = workStudy;
	}


	public boolean isPayRate() {
		return payRate;
	}


	public void setPayRate(boolean payRate) {
		this.payRate = payRate;
	}

	

	@Override
	public String toString() {
		return "StudentEmployee [hoursWorked=" + hoursWorked + ", WorkStudy=" + WorkStudy + ", payRate=" + payRate
				+ "]";
	}


	@Override
  	public double getPay() {
  		System.out.println("I'm getPay form StundetEmployee");
  		return 0;
  		
  	}*/
	
	 //instance fields
	   private int hoursWorked;
	   private boolean isWorkStudy;
	   private double payRate;
	   
	   //constructor
	   public StudentEmployee(String name, String number, String working,
	      String hours, String workstudy, String rate) {
	      
	      //call superclass constructor
	      super(name, number, working);
	      
	      //parse remaining data into private fields
	      hoursWorked = Integer.parseInt(hours);
	      isWorkStudy = Boolean.parseBoolean(workstudy);
	      payRate = Double.parseDouble(rate);
	   }
	   
	   //getPay method returns payRate time hoursWorked
	   public double getPay() {
		   if (isWorking) {
				payRate = (hoursWorked * payRate);
			}
			return payRate;
	   }
	   
	   //toString prints out the attributes of the object
	   public String toString() {
	      return super.toString() + "\t" + hoursWorked + "\t" +
	         isWorkStudy + "\t" + payRate;
	   }
}
