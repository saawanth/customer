

public class Student {
	String name;
	String date;
	String email;
	
	
	
	public Student(String name,String datePattern, String email) {
		this.name=name;
		this.date=datePattern;
		this.email=email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Name=" + name + ", DOB=" + date + ", email=" + email;
	}

	
}

