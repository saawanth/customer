package com.codeassignment.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeassignment.model.Customer;
import com.codeassignment.model.Job;
import com.codeassignment.service.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerService.findAllCustomers();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<List<Job>> getCustomerJobs(@PathVariable long customerId) {
		List<Job> customerJobs = customerService.findCustomerJobs(customerId);
		return new ResponseEntity<List<Job>>(customerJobs, HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Job>> getCustomerJobsByDate(
			@RequestParam(name = "customerName", required = false) String customername,
			@RequestParam(name = "fromDate", required = false) String fromDateStr,
			@RequestParam(name = "toDate", required = false) String toDateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date fromDate = null;
		Date toDate = null;
		try {
			fromDate = sdf.parse(fromDateStr);
			toDate = sdf.parse(toDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<Job> jobs = customerService.findJobsByDate(fromDate, toDate);
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
	}

}
