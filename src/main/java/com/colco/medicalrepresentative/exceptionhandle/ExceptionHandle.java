package com.colco.medicalrepresentative.exceptionhandle;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ExceptionHandle extends RuntimeException{
	
	private StatusResponse statusResponse;
	private  int code;
    private String message;
	public StatusResponse getStatusResponse() {
		return statusResponse;
	}
	public void setStatusResponse(StatusResponse statusResponse) {
		this.statusResponse = statusResponse;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ExceptionHandle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExceptionHandle(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public ExceptionHandle(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ExceptionHandle(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public ExceptionHandle(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public ExceptionHandle(StatusResponse statusResponse, int code, String message) {
		super();
		this.statusResponse = statusResponse;
		this.code = code;
		this.message = message;
	}
	



}
