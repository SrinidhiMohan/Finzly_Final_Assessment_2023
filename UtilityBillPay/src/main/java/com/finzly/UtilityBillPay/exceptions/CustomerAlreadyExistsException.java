package com.finzly.UtilityBillPay.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException{
	CustomerAlreadyExistsException(String message){
		super(message);
	}
	CustomerAlreadyExistsException(){
		super();
	}
	
}
