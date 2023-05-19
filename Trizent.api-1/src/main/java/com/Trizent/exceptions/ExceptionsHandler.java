package com.Trizent.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleDataNotFoundException(DataNotFoundException ex){
		String message = ex.getMessage();
		
		ErrorMessage message1 = new ErrorMessage();
		message1.setErrorMessage(message);
		return new ResponseEntity<ErrorMessage>(message1,HttpStatus.NOT_FOUND);
		
	}
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ErrorMessage> handleValidationException(MethodArgumentNotValidException ex) {
		   
		   
		   ErrorMessage message1 = new ErrorMessage();
		   message1.setErrorMessage("field validation error");
		   message1.setErrors(new ArrayList<>());
		   
		   
		   List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		   for (FieldError fieldError : fieldErrors) {
			   message1.getErrors().add(fieldError.getDefaultMessage());
			
		}
		 
		   
		   
		   return new ResponseEntity<ErrorMessage>(message1,HttpStatus.BAD_REQUEST);
		   
		   
		  
		   
	   }
	   @ExceptionHandler(DuplicateEmailException.class)
	    public ResponseEntity<String> duplicateEmailException(DuplicateEmailException ex) {
		 
		   
		   return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	   }
	

}
