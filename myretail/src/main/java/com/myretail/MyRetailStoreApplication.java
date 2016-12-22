package com.myretail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MyRetailStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyRetailStoreApplication.class, args);
	}

	// @Bean
	// public WebMvcConfigurer corsConfigurer() {
	// return new WebMvcConfigurerAdapter() {
	// @Override
	// public void addCorsMappings(CorsRegistry registry) {
	// registry.addMapping("/**").allowedOrigins("http://localhost:8080");
	// // registry.addMapping("/**").allowedOrigins("*"); // allows all
	// // origins
	// }
	// };
	// }
}