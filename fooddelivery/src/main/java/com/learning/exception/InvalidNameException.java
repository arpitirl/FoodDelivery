package com.learning.exception;

import lombok.ToString;

@ToString(callSuper = true)

public class InvalidNameException extends Exception {
	
	public InvalidNameException(String msg) {
		
		super(msg);
	} 

}
