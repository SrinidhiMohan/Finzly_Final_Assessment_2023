package com.finzly.UtilityBillPay.exceptions;

public class InvalidUserIdException extends RuntimeException{
	InvalidUserIdException(){
		super();
	}
	
	InvalidUserIdException(String message){
		super(message);
	}
}
