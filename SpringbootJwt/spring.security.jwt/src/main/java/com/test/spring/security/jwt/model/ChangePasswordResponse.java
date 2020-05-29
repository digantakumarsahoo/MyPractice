package com.test.spring.security.jwt.model;

public class ChangePasswordResponse {
	private boolean status;
	private String message;
	
	public ChangePasswordResponse(boolean status, String message) {
		this.status = status;
		this.message = message;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
		
	

}
