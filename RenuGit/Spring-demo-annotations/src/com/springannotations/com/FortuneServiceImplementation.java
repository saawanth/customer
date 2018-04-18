package com.springannotations.com;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImplementation implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}
