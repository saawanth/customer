package com.springannotations.com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {
	public static void main(String args[]) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach racketCoach = context.getBean("tennisCoach", Coach.class);

		System.out.println("Result " + (theCoach == racketCoach));
		
		System.out.println("Address 1 "+theCoach);
		System.out.println("Address 2 " +racketCoach);

		context.close();
	}
}
