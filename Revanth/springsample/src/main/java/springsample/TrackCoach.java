package springsample;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;

	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just do it: " + fortuneService.getFortune();
	}

	public void startMyStuff() {
		System.out.println("Inside: startMyStuff");
	}

	public void endMyStuff() {
		System.out.println("Inside:endMyStuff");
	}
}
