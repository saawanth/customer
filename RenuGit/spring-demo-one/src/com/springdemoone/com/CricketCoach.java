package com.springdemoone.com;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	public void setEmailAddress(String emailAddress) {
		System.out.println("We are doing a cricket Coach setter method for email address!");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("We are doing a cricket Coach setter method for the team!");
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public CricketCoach(){
		System.out.println("We are doing a cricket Coach constructor!");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("We are doing a cricket Coach setter method!");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
			return "Practise batting for atleast 15 mins each day!";
	}

	@Override
	public String getDailyFortune() {
			return fortuneService.getFortune();
	}

	

}
