package com.learning.exception;

import lombok.ToString;

//this thing is an alternate for the override function toString() below
@ToString(callSuper = true)

public class InvalidIdLengthException extends Exception {
	
	
	public InvalidIdLengthException(String message) {
		super(message);
		
	}


	
}
