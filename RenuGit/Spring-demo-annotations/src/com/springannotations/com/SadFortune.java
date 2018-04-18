package com.springannotations.com;

public class SadFortune implements FortuneService {

	@Override
	public String getFortune() {		
		return "Today is a sad day!";
	}

}
