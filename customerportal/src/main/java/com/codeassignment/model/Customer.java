package com.codeassignment.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "contact_number")
	private String contactNumber;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonIgnore
	public List<Job> jobs;

	public Customer() {
	}

	public Customer(long customerId, String customerName, String state, String contactNumber) {
		this.id = customerId;
		this.customerName = customerName;
		this.state = state;
		this.contactNumber = contactNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + id + ", customerName=" + customerName + ", state=" + state + ", contactNumber="
				+ contactNumber + "]";
	}

}
