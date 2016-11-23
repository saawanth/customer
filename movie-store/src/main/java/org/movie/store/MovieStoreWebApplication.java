package org.movie.store;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

public class MovieStoreWebApplication extends SpringBootServletInitializer{

  @Override
  protected SpringApplicationBuilder configure(
          SpringApplicationBuilder builder) {
      return builder.sources(MovieStoreApplication.class);
  } 

}
