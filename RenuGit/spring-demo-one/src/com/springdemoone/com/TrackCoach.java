package com.springdemoone.com;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService theFortuneService){
		this.fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
			return "Run 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it!" +fortuneService.getFortune();
	}

}
