package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy 
public class Moviestore1Application {

	public static void main(String[] args) {
		SpringApplication.run(Moviestore1Application.class, args);
			}
	
}
