package com.springannotations.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.springannotations.com")
@PropertySource("classpath:details.properties")
public class SportConfig {
	
	@Bean
	public FortuneService sadFortune(){
		return new SadFortune();
	}

	@Bean
	public Coach swimCoach(){
		return new SwimCoach(sadFortune());
	}
}
