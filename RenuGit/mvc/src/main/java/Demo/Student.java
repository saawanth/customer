package Demo;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;	
	private LinkedHashMap<String,String> countryOptions; 
	private String favoriteLanguage;
	private String OS;
	
	public Student(){
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BR","Brazil");
		countryOptions.put("PR","Peru");
		countryOptions.put("IN","India");
		countryOptions.put("PK","Pakistan");
		countryOptions.put("U","US");
			}
	
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}
	public String getOS() {
		return OS;
	}

	public void setOS(String oS) {
		OS = oS;
	}
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

}
