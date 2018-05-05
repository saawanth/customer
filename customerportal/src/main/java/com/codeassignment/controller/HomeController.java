package com.codeassignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/searchcustomerjobs")
	public String searchCustomerJobs() {
		return "searchcustomerjobs";
	}
}
