package org.movie.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableAutoConfiguration
// @SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
// HibernateJpaAutoConfiguration.class })
@SpringBootApplication
@EnableWebMvc
@EnableJpaRepositories(basePackages = "org.movie.store.repository")
public class MovieStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieStoreApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:8080");
				// registry.addMapping("/**").allowedOrigins("*"); // allows all
				// origins
			}
		};
	}
}