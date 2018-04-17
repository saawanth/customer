package springsample.springAnnotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
	private String[] fortunes = { "re", "va", "nth" };
	{
		System.out.println("HappyfortuneService: Inside the constructor");
	}

	public String getFortune() {
		Random rand = new Random();
		return fortunes[rand.nextInt(fortunes.length)];
	}

}
