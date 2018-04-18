package com.springdemoone.com;

public class BaseballCoach implements Coach {
	
public FortuneService fortuneService;
	
	public BaseballCoach(FortuneService theFortuneService){
		this.fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes batting";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public void beanStartUp(){
		System.out.println("The been had started yo!");
	}
	
	public void beanDestroy(){
		System.out.println("The bean is being destroyed yo!");
	}

}
