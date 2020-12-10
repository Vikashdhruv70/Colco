package com.colco.medicalrepresentative.exceptionhandle;



public class Error {
	
	private int errorcode;
	
	private String message;
	
	private Object stackTrace;
	
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getStackTrace() {
		return stackTrace;
	}
	public void setStackTrace(Object printStackTrace) {
		this.stackTrace=printStackTrace;
		
	}

}
