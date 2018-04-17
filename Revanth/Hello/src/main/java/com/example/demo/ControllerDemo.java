package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDemo {
	
	@RequestMapping("/hi")
	public String hello() {
		return "hello world";
	}

}
