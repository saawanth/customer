package springsample.springAnnotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	private String[] data = { "Lucky Day", "Good day!", "Nice day!" };
	private Random random = new Random();

	public String getFortune() {
		// TODO Auto-generated method stub
		return data[random.nextInt(data.length)];
	}

}
