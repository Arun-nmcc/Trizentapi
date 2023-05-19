package com.Trizent.exceptions;

public class DuplicateEmailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -461808774382752259L;
	public DuplicateEmailException(String message) {
		super(message);
	}

}
