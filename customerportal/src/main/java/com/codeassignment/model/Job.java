package com.codeassignment.model;


import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "job_type")
	private String jobType;

	@Column(name = "job_status")
	private String jobStatus;

	@Column(name = "due_date")
	private Date dueDate;

	@Column(name = "miss_comment")
	private String missComment;

	@Column(name = "notification_sent")
	private String notificationSent;

	@Column(name = "return_message")
	private String returnMessage;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "customer_id")
	public Customer customer;

	public Job() {
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getMissComment() {
		return missComment;
	}

	public void setMissComment(String missComment) {
		this.missComment = missComment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getNotificationSent() {
		return notificationSent;
	}

	public void setNotificationSent(String notificationSent) {
		this.notificationSent = notificationSent;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + id + ", jobType=" + jobType + ", jobStatus=" + jobStatus + ", dueDate=" + dueDate
				+ ", missComment=" + missComment + ", notificationSent=" + notificationSent + ", returnMessage="
				+ returnMessage + "]";
	}

}
