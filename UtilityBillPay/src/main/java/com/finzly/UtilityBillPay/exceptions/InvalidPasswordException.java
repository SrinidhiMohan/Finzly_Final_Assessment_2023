package com.finzly.UtilityBillPay.exceptions;

public class InvalidPasswordException extends RuntimeException {
	InvalidPasswordException(){
		super();
	}
	InvalidPasswordException(String message){
		super(message);
	}

}
