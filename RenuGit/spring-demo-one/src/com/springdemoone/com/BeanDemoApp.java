package com.springdemoone.com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanDemoApp {
	
	public static void main(String args[]){
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanScope.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach theAlphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean result = (theCoach == theAlphaCoach);
		
		System.out.println("Let's print the result " +result);
		System.out.println("Address of theCoach " +theCoach);
		System.out.println("Address of theAlphaCoach " +theAlphaCoach);
		
		context.close();
	}

}
