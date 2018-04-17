package springmvcdemo;

import java.util.LinkedHashMap;
import java.util.Locale;

public class Student {
	private String firstName;

	private String lastName;
	private String country;
	private LinkedHashMap<String, String> countryOptions;
	private String favoriteLanguage;
	private LinkedHashMap<String, String> favoriteLanguageOptions;
	private String[] operatingSystems;

	public Student() {
		countryOptions = new LinkedHashMap<>();
		Locale locale = Locale.GERMAN;
		for (Locale locale1 : Locale.getAvailableLocales()) {
			countryOptions.put(locale1.getCountry(), locale1.getDisplayCountry());
		}
		// countryOptions.put("BR", "Brazil");
		// countryOptions.put("FR", "France");
		// countryOptions.put("IN", "India");
		// countryOptions.put("DR", "Germany");
		// countryOptions.put("US", "UnitedStates");
		favoriteLanguageOptions = new LinkedHashMap();
		favoriteLanguageOptions.put("Java", "Java");
		favoriteLanguageOptions.put("Python", "Python");
		favoriteLanguageOptions.put("C#", "C#");
		favoriteLanguageOptions.put("Ruby", "Ruby");
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

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

}
