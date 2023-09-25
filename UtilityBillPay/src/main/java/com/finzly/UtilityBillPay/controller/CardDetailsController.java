package com.finzly.UtilityBillPay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.UtilityBillPay.entity.carddetails;
import com.finzly.UtilityBillPay.service.CardDetailsService;
@CrossOrigin(origins = "http://localhost:60879")
@RestController
public class CardDetailsController {
	@Autowired
	CardDetailsService cardDetailsService;
	
	@PostMapping("addCardDetails")
	public String addCardDetails(@RequestBody carddetails carddetails) {
		return cardDetailsService.addCardDetails(carddetails);
	}
	
	

}
