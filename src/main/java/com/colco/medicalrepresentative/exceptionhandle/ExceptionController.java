package com.colco.medicalrepresentative.exceptionhandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ExceptionController extends ResponseEntityExceptionHandler  {
private final static Logger LOG= LoggerFactory.getLogger(ExceptionController.class);
	
	
	/*@ExceptionHandler(value = {HttpMessageNotReadableException.class})
	public ResponseEntity<Object>handleException(HttpMessageNotReadableException eh,WebRequest request)
	{

		String body="Parsing not Found";
		return handleExceptionInternal(eh, body, new HttpHeaders(),HttpStatus.BAD_REQUEST, request);
	}*/
	
	

	@ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity<Object> handleException(NullPointerException eh,WebRequest request)
	{
		Error error=new Error();
		error.setErrorcode(StatusResponse.INTERNAL_SERVER_ERROR.getCode());
		error.setMessage(StatusResponse.INTERNAL_SERVER_ERROR.getReason());
		error.setStackTrace(eh.getStackTrace());
		//String body="somthing is fishy";
		return handleExceptionInternal(eh, error, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	@ExceptionHandler(value = {ExceptionHandle.class})
	public ResponseEntity<Object>handleException(ExceptionHandle eh,WebRequest request)
	{
		Error error=new Error();
		error.setErrorcode(eh.getCode());
		error.setMessage(eh.getMessage()); 
		//String body="Something is wrong";
		return handleExceptionInternal(eh, error, new HttpHeaders(),HttpStatus.BAD_REQUEST, request);
	}
	
}
