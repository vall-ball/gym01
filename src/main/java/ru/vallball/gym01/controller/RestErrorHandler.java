package ru.vallball.gym01.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RequestMapping(produces = "application/json;charset=UTF-8")
public class RestErrorHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({RuntimeException.class})
	public ResponseEntity<Object> handleSQLException(RuntimeException ex, WebRequest request) {
		System.out.println(ex.getMessage());
		ex.printStackTrace();
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
				
		headers.add("Content-type", "application/json;charset=UTF-8");
		String bodyOfResponse = exception.getMessage();
		System.out.print("эдвайс " + bodyOfResponse);
		return new ResponseEntity<>(bodyOfResponse, headers, status);
	}

	
}
