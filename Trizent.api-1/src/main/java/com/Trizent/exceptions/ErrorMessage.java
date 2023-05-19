package com.Trizent.exceptions;

import java.util.List;

public class ErrorMessage {
	private String errorMessage;
	private List<String> errors;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	

}
