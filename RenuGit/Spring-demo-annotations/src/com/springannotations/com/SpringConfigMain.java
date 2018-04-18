package com.springannotations.com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfigMain {
	
	public static void main(String args[]){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		System.out.println("Executing this! " +theCoach.dailyWorkOut());
		System.out.println("Today's Fortune! " +theCoach.getDailyFortune());
		
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		context.close(); 
	}

}
