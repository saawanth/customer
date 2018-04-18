package com.springannotations.com;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("RESTFortune")
	private FortuneService fortuneService;
	
	 
	 public TennisCoach(){
	 System.out.println("Contrustor");
	 }
	 
	 @PostConstruct
	 public void doMyStart(){
		 System.out.println("Inside the start!");
	 }
	 
	 @PreDestroy
	 public void doMyCleanUp(){
		 System.out.println("Getting outside of the bean!");
	 }

//	@Autowired
//	public void myMethod(FortuneService fortuneService) {
//		System.out.println("We are working on the method injection using autowired");
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String dailyWorkOut() {
		return "Push-Ups for 30 minutes!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
