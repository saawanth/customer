package com.moviestore.exception;

import java.util.Date;

public class ApiErrorResponse {

	private Date timestamp;
	private String message;
	private String details;

	public ApiErrorResponse(Date timestamp, String message, String details) {

		this.timestamp = timestamp;
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

//	@Override
//	public String toString() {
//		return new toStringBuilder(this).append(status).append(message).toString();
//	}
}
