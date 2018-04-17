package com.example.exemptionhandler;

import java.util.Date;

public class ErrorDetails {
	private Date timestamp;
	private String myMsg;
	private String message;
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.myMsg = "Sorry for the inconvenience caused!";
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public String getmyMsg() {
		return myMsg;
	}
}
