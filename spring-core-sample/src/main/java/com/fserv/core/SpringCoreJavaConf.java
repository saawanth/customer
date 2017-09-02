package com.fserv.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fserv.repo.InMemoryUserRepo;
import com.fserv.repo.UserRepo;

@Configuration
public class SpringCoreJavaConf {
	
	@Bean(name="inMemoryRepo")
	public UserRepo inMemoryRepo() {
		return new InMemoryUserRepo(); 
	}

}
