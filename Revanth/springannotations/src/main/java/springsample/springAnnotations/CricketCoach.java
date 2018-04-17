package springsample.springAnnotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
	

	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practise Kepping for 30 minutes";
	}

	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
