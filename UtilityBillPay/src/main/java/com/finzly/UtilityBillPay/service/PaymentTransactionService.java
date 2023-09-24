package com.finzly.UtilityBillPay.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.UtilityBillPay.entity.TransactionOtp;
import com.finzly.UtilityBillPay.entity.carddetails;
import com.finzly.UtilityBillPay.dao.PaymentTransactionDao;
import com.finzly.UtilityBillPay.entity.paymenttransaction;

@Service
public class PaymentTransactionService {


	@Autowired
	PaymentTransactionDao paymentTransactionDao;
//	@Autowired
//	carddetails carddetails;
	@Autowired
	SessionFactory factory;
	
	public String payOnline(paymenttransaction paymenttransaction) {
	
		Session session = factory.openSession();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(carddetails.class);
		Criteria criteria1 = session.createCriteria(TransactionOtp.class);
		int cardfound =0;
		int suffamount =0;
		int validOtp =0;
		
		@SuppressWarnings("unchecked")
		List<carddetails> cardinfo = criteria.list();
		for (carddetails carddetails : cardinfo) {
			if(paymenttransaction.getCardnumber() == carddetails.getCardnumber()) {
				cardfound++;
				if((carddetails.getBalance()-paymenttransaction.getPaymentamt()) >carddetails.getMinimumbalance()) {
					suffamount++;
				}
			}
		}
//		List<TransactionOtp> transotp = criteria1.list();
//		for (TransactionOtp transactionOtp : transotp) {
//			if(paymenttransaction.getTransactionid()==transactionOtp.getTransactionid()) {
//				validOtp++;
//			}
//		}
		
		if(cardfound <=0) {
			paymenttransaction.setTransactionstatus("Failed");
			paymenttransaction.setPaymentmethod("cash");
			session.beginTransaction().commit();
			return "Card Declined";
		}else if(suffamount <=0){
			paymenttransaction.setTransactionstatus("Failed");
			paymenttransaction.setPaymentmethod("cash");
			session.beginTransaction().commit();
			return "Insufficient funds !!";
			
		}
		//else if(validOtp==0) {
//			return "Invalid OTP";
//		}
	else {
			paymenttransaction.setTransactionstatus("Success");
			paymenttransaction.setReferencenumber(generateRandomUnique6DigitNumber());
			paymenttransaction.setPaymentmethod("online");
			session.beginTransaction().commit();
			return paymentTransactionDao.payOnline(paymenttransaction);
		}
	}
		
	
	
	public String deletePaymentById(long transactionid) {
		
		return paymentTransactionDao.deletePaymentById(transactionid);
	}

	
	
	
	
	
//    public static long generateRandomUnique6DigitNumber() {
//        Random random = new Random();
//        Set<Long> uniqueNumbers = new HashSet<>();
//        
//        while (uniqueNumbers.size() < 1000000) { // Loop until a unique 6-digit number is generated
//            long randomNumber = 100_000 + (long)(random.nextDouble() * 900_000); // Generates a 6-digit long number
//            uniqueNumbers.add(randomNumber);
//        }
//      
//        Long[] uniqueArray = uniqueNumbers.toArray(new Long[0]);
//      
//        int randomIndex = random.nextInt(uniqueArray.length);
//        
//        return uniqueArray[randomIndex];
//    }
    public static long generateRandomUnique6DigitNumber() {
        Random random = new Random();
        long lowerBound = 100_000;
        long upperBound = 999_999;
        
        long uniqueNumber = lowerBound + random.nextLong() % (upperBound - lowerBound + 1);
        
        return uniqueNumber;
    }

}
