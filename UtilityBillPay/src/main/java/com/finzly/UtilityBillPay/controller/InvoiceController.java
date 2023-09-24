package com.finzly.UtilityBillPay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.UtilityBillPay.entity.Invoice;
import com.finzly.UtilityBillPay.entity.billtable;
import com.finzly.UtilityBillPay.service.InvoiceService;


@RestController
public class InvoiceController {
     
	@Autowired
	private InvoiceService invoiceService;
	
	@GetMapping("getAllPaidBills/{id}")
	public List<Invoice> getAllPaidBills(@PathVariable long id) {
		return invoiceService.getAllPaidBills(id);
	}
	
	@GetMapping("getAllPendingBills/{id}")
	public List<Invoice> getAllPendingBills(@PathVariable long id) {
		return invoiceService.getAllPendingBills(id);
	}
}
