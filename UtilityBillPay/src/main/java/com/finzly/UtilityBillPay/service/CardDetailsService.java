package com.finzly.UtilityBillPay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finzly.UtilityBillPay.dao.CardDetsilsDao;
import com.finzly.UtilityBillPay.entity.carddetails;

@Service
public class CardDetailsService {
	
	@Autowired
	CardDetsilsDao cardDetailsDao;

	public String addCardDetails(carddetails carddetails) {
		
		return cardDetailsDao.addCardDetails(carddetails);
	}
	
	
	

}
