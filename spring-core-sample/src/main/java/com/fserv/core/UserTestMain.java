package com.fserv.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fserv.model.User;
import com.fserv.service.UserService;

@Configuration
public class UserTestMain {

  public static void main(String[] args) {
    // String str = "Revanth";
    // String str1 = str.concat("r");
    // System.out.println(str);
    // System.out.println(str1);

//    UserRepo userRepo = new InMemoryUserRepo();
//    UserService userService = new UserServiceImpl(userRepo);
//    
//    userService.find("ash");
//    
    ApplicationContext appContext =
        new ClassPathXmlApplicationContext("classpath:applicaitonContext.xml");
    UserService userService = (UserService) appContext.getBean("userServiceImpl");

    User usr = new User();
    usr.setName("Raja");
    usr.setUsername("reddy");

    User user = userService.createUser(usr);
    User retrievedUsr = userService.find(usr.getUsername());
    System.out.println("is user not null " + (retrievedUsr != null));
  }
}
