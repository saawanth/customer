package com.springdemoone.com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
	
	public static void main(String args[]){
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanLifeCycle.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
				
		context.close();
	}

}
