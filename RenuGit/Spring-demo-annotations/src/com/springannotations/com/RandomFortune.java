package com.springannotations.com;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortune implements FortuneService {
	
	String[] array = {"Diligence", "Hardwork", "Dedication"};
	
	Random random = new Random();
	int index = random.nextInt(array.length);

	@Override
	public String getFortune() {
		String theFortune = array[index];
		return theFortune;
	}

}
