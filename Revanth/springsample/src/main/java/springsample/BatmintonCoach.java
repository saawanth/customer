package springsample;

public class BatmintonCoach implements Coach {
	private FortuneService fortuneService;

	public BatmintonCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("Batminton con called!");
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("Batminton setter method called!");
	}

	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practise back shots";
	}

	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
