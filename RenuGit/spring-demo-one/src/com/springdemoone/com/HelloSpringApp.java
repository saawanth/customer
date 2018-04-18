package com.springdemoone.com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
	public static void main(String args[]) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		BaseballCoach theCoach = context.getBean("myCoach", BaseballCoach.class);
		BaseballCoach thedonkey = context.getBean("myCoach", BaseballCoach.class);
		
		System.out.println("Address" +theCoach);
		System.out.println("Address "+ thedonkey);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		context.close();
	}

}
