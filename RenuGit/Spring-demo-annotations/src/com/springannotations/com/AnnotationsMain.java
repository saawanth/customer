package com.springannotations.com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsMain {
	
	public static void main(String args[]){
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach racketCoach = context.getBean("racketballCoach", Coach.class);
		
		System.out.println("Executing this! " +theCoach.dailyWorkOut());
		System.out.println("Executing another! " +racketCoach.dailyWorkOut());
		System.out.println("Today's Fortune! " +theCoach.getDailyFortune());
		
		context.close(); 
	}

}
