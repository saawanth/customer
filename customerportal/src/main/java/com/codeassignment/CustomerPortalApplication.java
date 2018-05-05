package com.codeassignment;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.codeassignment.model.Customer;
import com.codeassignment.model.Job;
import com.codeassignment.repo.CustomerRepository;

@SpringBootApplication
public class CustomerPortalApplication {

	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerPortalApplication.class, args);
	}

	@PostConstruct
	public void setupDbWithData() {
		Customer customer = new Customer();
		customer.setCustomerName("Revanth");
		customer.setState("MI");

		List<Job> jobs = new ArrayList<>();
		Job job = new Job();
		job.setCustomer(customer);
		job.setJobStatus("Pending");
		job.setJobType("Cable");
		job.setDueDate(new Date(System.currentTimeMillis()));
		jobs.add(job);

		job = new Job();
		job.setCustomer(customer);
		job.setJobStatus("Completed");
		job.setDueDate(new Date(System.currentTimeMillis()));
		job.setJobType("Internet");

		jobs.add(job);

		customer.setJobs(jobs);

		customer = customerRepository.save(customer);

		// User user = new User("Ashish", null);
		// user.setSkills(Arrays.asList(new Skill("java"), new Skill("js")));
		//
		// user = userRepository.save(user);
	}

}
