package com.sample.test;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

public class TestWebApp extends SpringBootServletInitializer{

  @Override
  protected SpringApplicationBuilder configure(
          SpringApplicationBuilder builder) {
      return builder.sources(TestApp.class);
  } 

}
