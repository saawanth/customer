package springsample.springAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	private String[] team = {"revanth","evadu"};
	
	
	// @Autowired
	// public TennisCoach(FortuneService fortuneService) {
	// this.fortuneService = fortuneService;
	//
	// }
	// @Autowired
	// public void setFortuneService(FortuneService fortuneService) {
	// this.fortuneService = fortuneService;
	// }

	public String[] getTeam() {
		return team;
	}

	public String getDailyWorkout() {
		return "Practise 30 minutes Tennis";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
