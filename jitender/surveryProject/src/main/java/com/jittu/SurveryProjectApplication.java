package com.jittu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SurveryProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveryProjectApplication.class, args);
	}
	
}
