package com.finzly.UtilityBillPay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.UtilityBillPay.entity.paymenttransaction;
import com.finzly.UtilityBillPay.service.PaymentTransactionService;

@RestController
public class PaymentTransactionController {
	@Autowired
	PaymentTransactionService paymentTransactionService;
	
	@PostMapping("payOnline")
	public String payOnline(@RequestBody paymenttransaction paymenttransaction) {
		
		return paymentTransactionService.payOnline(paymenttransaction);
	}
	   @DeleteMapping("deletePayment/{transactionid}")
	   public String deletePaymentById(@PathVariable long transactionid) {
	      return paymentTransactionService.deletePaymentById(transactionid);
	   }

}
