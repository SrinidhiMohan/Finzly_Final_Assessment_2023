package com.finzly.UtilityBillPay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.UtilityBillPay.entity.paymenttransaction;
import com.finzly.UtilityBillPay.service.PaymentTransactionService;
@CrossOrigin(origins = "http://localhost:60879")
@RestController
public class PaymentTransactionController {
	@Autowired
	PaymentTransactionService paymentTransactionService;
	
	@PostMapping("payOnline")
	public String payOnline(@RequestBody paymenttransaction paymenttransaction) {

		return paymentTransactionService.payOnline(paymenttransaction);
	}

	@GetMapping("getReceipt/{transactionid}")
	public List<paymenttransaction> getReceipt(@PathVariable long transactionid) {
		return paymentTransactionService.getReceipt(transactionid);
	}

	@DeleteMapping("deletePayment/{transactionid}")
	public String deletePaymentById(@PathVariable long transactionid) {
		return paymentTransactionService.deletePaymentById(transactionid);
	}
}

