
public class Employee {
	String email;
	String firstname;
	String lastname;
	
	public Employee(String email,String firstname,String lastname){
			this.email=email;
			this.firstname=firstname;
			this.lastname=lastname;
		
	}

	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
