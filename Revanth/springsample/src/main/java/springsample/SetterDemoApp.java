package springsample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CricketCoach criCoach = context.getBean("myCricketCoach", CricketCoach.class);
		System.out.println(criCoach.getDailyWorkout());
		System.out.println(criCoach.getDailyFortune());
		System.out.println(criCoach.getEmailAddress());
		System.out.println(criCoach.getTeam());

		context.close();
	}

}
