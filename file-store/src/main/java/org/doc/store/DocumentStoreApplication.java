package org.doc.store;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// @EnableAutoConfiguration
// @SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
// HibernateJpaAutoConfiguration.class })
@SpringBootApplication
@EnableWebMvc
// @EnableJpaRepositories(basePackages = "org.movie.store.repository")

public class DocumentStoreApplication {
  public static void main(String[] args) {
    SpringApplication.run(DocumentStoreApplication.class, args);
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

  @Bean
  MultipartConfigElement multipartConfigElement() {
    MultipartConfigFactory factory = new MultipartConfigFactory();
    factory.setMaxFileSize("5120MB");
    factory.setMaxRequestSize("5120MB");
    return factory.createMultipartConfig();
  }
  
  // @Bean
  // public MultipartResolver multipartResolver() {
  // org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new
  // org.springframework.web.multipart.commons.CommonsMultipartResolver();
  // multipartResolver.setMaxUploadSize(1000000);
  // return multipartResolver;
  // }
}
