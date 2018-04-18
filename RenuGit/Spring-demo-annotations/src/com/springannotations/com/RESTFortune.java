package com.springannotations.com;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class RESTFortune implements FortuneService {

	@Value("${Fortune1}")
	private String fortune1;
	@Value("${Fortune2}")
	private String fortune2;
	@Value("${Fortune3}")
	private String fortune3;

	@PostConstruct
	public String data() {
		String[] array = { fortune1, fortune2, fortune3 };
		Random random = new Random();
		int index = random.nextInt(array.length);
		String theFortune = array[index];
		return theFortune;
	}

	@Override
	public String getFortune() {
		return data();
	}

}
