package com.springannotations.com;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortune implements FortuneService {

	@Override
	public String getFortune() {
		return null;
	}

}
