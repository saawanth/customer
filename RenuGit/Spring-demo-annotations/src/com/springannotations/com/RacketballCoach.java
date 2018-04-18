package com.springannotations.com;

import org.springframework.stereotype.Component;

@Component
public class RacketballCoach implements Coach {

	@Override
	public String dailyWorkOut() {
		return "Make sure you wake 10 minutes early each day and drink hot water";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
