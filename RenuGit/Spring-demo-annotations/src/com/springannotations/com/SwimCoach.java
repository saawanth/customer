package com.springannotations.com;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	public FortuneService fortuneService;
	@Value("${email}")
	private String emailAddress;
	@Value("${team}")
	private String team;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public SwimCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String dailyWorkOut() {
		return "Swim for 30 minutes as a warm up!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
