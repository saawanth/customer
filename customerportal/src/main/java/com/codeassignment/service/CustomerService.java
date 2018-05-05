package com.codeassignment.service;

import java.util.Date;
import java.util.List;

import com.codeassignment.model.Customer;
import com.codeassignment.model.Job;

public interface CustomerService {

	List<Job> findAllJobs();

	List<Job> findCustomerJobs(long customerId);

	List<Customer> findAllCustomers();

	List<Job> findJobsByDate(Date date1, Date date2);
}
