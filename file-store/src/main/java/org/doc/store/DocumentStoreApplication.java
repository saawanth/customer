package org.doc.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableAutoConfiguration
// @SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
// HibernateJpaAutoConfiguration.class })
@SpringBootApplication
@EnableWebMvc
// @EnableJpaRepositories(basePackages = "org.movie.store.repository")
public class DocumentStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(DocumentStoreApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("http://localhost:8080");
//				// registry.addMapping("/**").allowedOrigins("*"); // allows all
//				// origins
//			}
//		};
//	}
}