package assignment3;

public abstract class Employee {

	/*public abstract double getPay();
	
	private String employeeName;
	private int employeeId;
	private boolean Working;
	public Employee() {
		
	}
	
	public Employee(String employeeName, int employeeId, boolean working) {
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		Working = working;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public boolean isWorking() {
		return Working;
	}

	public void setWorking(boolean working) {
		Working = working;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeId=" + employeeId + ", Working=" + Working + "]";
	}*/
	public  String employeeName;
	public  int employeeId;
	public boolean isWorking; // true if currently working; false otherwise
	      
	   // Constructor - All args passed in as Strings
	   public Employee(String name, String id, String isworking) {
	      employeeName = name;
	      employeeId = Integer.parseInt(id);
	      isWorking = Boolean.parseBoolean(isworking);
	   }


		public String getEmployeeName() {
			return employeeName;
		}

		public int getEmployeeId() {
			return employeeId;
		}

		public boolean isWorking() {
			return isWorking;
		}


	   @Override
		public String toString() {
		   
			      return super.toString() + "\t" + employeeName + "\t" +
			    		  employeeId + "\t" + isWorking;
			   
		}


	public abstract double getPay();
}
