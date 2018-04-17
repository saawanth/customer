package springsample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		Coach theCoach = context.getBean("myCoach", Coach.class);

		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		boolean res = (theCoach == alphaCoach);

		System.out.println("\nsame obj: " + res);
		System.out.println("\nMemory location: " + theCoach);
		System.out.println("\nMemory location: " + alphaCoach);
		context.close();
	}

}
