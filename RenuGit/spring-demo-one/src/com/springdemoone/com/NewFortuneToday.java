package com.springdemoone.com;

import java.util.Random;

public class NewFortuneToday implements FortuneService {
	
	String[] array = {"Good day", "Great day", "Best day"};
	
	 @Override
	public String getFortune() {
		 int rnd = new Random().nextInt(array.length);
		    return array[rnd];
	}

}
