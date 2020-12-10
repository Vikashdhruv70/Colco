package com.colco.medicalrepresentative.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseStatus {

  private int code;

  private String message;
  
  private Object responseObj;
  

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

public ResponseStatus(int code, String message, Object responseObj) {
	super();
	this.code = code;
	this.message = message;
	this.responseObj = responseObj;
}

public Object getResponseObj() {
	return responseObj;
}

public void setResponseObj(Object responseObj) {
	this.responseObj = responseObj;
}

public ResponseStatus() {
	super();
	// TODO Auto-generated constructor stub
}
  
  public ResponseStatus(int code,String message)
  {
	  super();
	  this.code=code;
	  this.message=message;
  }
  

 
}
