package com.finzly.UtilityBillPay.exceptions;

import org.springframework.stereotype.Component;


@Component
public class GlobalExceptionHandler {
	
	public static void getCustomerAlreadyExistsException(String message) {
		throw new CustomerAlreadyExistsException(message);
	}
	
	public static void getInvalidUserIdException(String message) {
		throw new InvalidUserIdException(message);
	}
	
	
	public static void getInvalidPasswordException(String message) {
		throw new InvalidPasswordException(message);
	}
}
