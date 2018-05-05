package com.codeassignment.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeassignment.model.Customer;
import com.codeassignment.model.Job;
import com.codeassignment.repo.CustomerRepository;
import com.codeassignment.repo.JobRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public List<Job> findAllJobs() {
		List<Job> tasks = (List<Job>) jobRepository.findAll();
		return tasks;
	}

	public List<Customer> findAllCustomers() {
		List<Customer> tasks = (List<Customer>) customerRepository.findAll();
		return tasks;
	}

	public List<Job> findJobsByDate(Date fromDate, Date toDate) {
//		List<Job> tasks = (List<Job>) jobRepository.findJobsByDate(new java.sql.Date(fromDate.getTime()), new java.sql.Date(toDate.getTime()));
		List<Job> tasks = (List<Job>) jobRepository.findAll();
		return tasks;
	}

	@Override
	public List<Job> findCustomerJobs(long customerId) {
		return jobRepository.findAllCustomerJobs(customerId);
	}
}
