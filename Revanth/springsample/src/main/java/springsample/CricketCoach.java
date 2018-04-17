package springsample;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	private String team;
	private String emailAddress;

	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("CricketCoach: inside setter method");
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice bowling for 60 minutes.";
	}

	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
