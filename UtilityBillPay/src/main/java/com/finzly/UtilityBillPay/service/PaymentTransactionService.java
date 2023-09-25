package com.finzly.UtilityBillPay.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finzly.UtilityBillPay.entity.Invoice;
import com.finzly.UtilityBillPay.entity.TransactionOtp;
import com.finzly.UtilityBillPay.entity.carddetails;
import com.finzly.UtilityBillPay.dao.PaymentTransactionDao;
import com.finzly.UtilityBillPay.entity.paymenttransaction;

@Service
public class PaymentTransactionService {


	@Autowired
private PaymentTransactionDao paymentTransactionDao;
//	@Autowired
//	carddetails carddetails;
	@Autowired
private	SessionFactory factory;
private	Date currentDate = new Date();
	
	public String payOnline(paymenttransaction paymenttransaction) {
	
		Session session = factory.openSession();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(carddetails.class);
		int cardfound =0;
		int suffamount =0;
		int validOtp =0;
		 Criteria criteria1 = session.createCriteria(TransactionOtp.class);
	        List<TransactionOtp> transactionotp = criteria1.list();
	        for (TransactionOtp transactionOtp2 : transactionotp) {
				if(transactionOtp2.getTransactionid()==paymenttransaction.getTransactionid()) {
					if(paymenttransaction.getOtp() == transactionOtp2.getOtp()) {
						//validOtp++;
					}	
				}
			}
		
		@SuppressWarnings("unchecked")
		List<carddetails> cardinfo = criteria.list();
		for (carddetails carddetails : cardinfo) {
			if(paymenttransaction.getCardnumber() == carddetails.getCardnumber()) {
				cardfound++;
				if((carddetails.getBalance()-paymenttransaction.getPaymentamt()) >carddetails.getMinimumbalance()) {
					carddetails.setBalance(carddetails.getBalance()-paymenttransaction.getPaymentamt());
					suffamount++;
				}
			}
		}
		@SuppressWarnings("unchecked")
		Criteria criteria2 = session.createCriteria(Invoice.class);
		List<Invoice> invoice = criteria2.list();
		for (Invoice in : invoice) {
			if(in.getBillingid() == paymenttransaction.getBid()) {
				in.setPaymentstatus("Paid");
				paymenttransaction.setPaymentamt(in.getTotalamt());
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
//		else if(validOtp==0) {
//			return "Invalid OTP";
//		}
	else {
		    paymenttransaction.setTransactionid(generateRandomPositive7DigitNumber());
			paymenttransaction.setTransactionstatus("Success");
			paymenttransaction.setReferencenumber(generateRandomUnique6DigitNumber());
			paymenttransaction.setPaymentmethod("online");
			paymenttransaction.setTransactiondate(currentDate);
			session.beginTransaction().commit();
			return paymentTransactionDao.payOnline(paymenttransaction);
		}
	}
	
	public List<paymenttransaction> getReceipt(long transactionid) {
		List<paymenttransaction> list = paymentTransactionDao.getReceipt(transactionid);
		List<paymenttransaction> modifiedList = new ArrayList();
		for (paymenttransaction payment : list) {
				long tid = payment.getTransactionid();
				long cid = payment.getCid();
				long bid = payment.getBid();
				String payMethod = payment.getPaymentmethod();
				String tStatus = payment.getTransactionstatus();
				long refNum = payment.getReferencenumber();
				long cardNum = payment.getCardnumber();
				double amt = payment.getPaymentamt();
				Date tDate = payment.getTransactiondate();
				paymenttransaction payment1 = new paymenttransaction();
				payment1.setTransactionid(tid);
				payment1.setCid(cid);	
				payment1.setBid(bid);
				payment1.setPaymentmethod(payMethod);
				payment1.setTransactionstatus(tStatus);
				payment1.setReferencenumber(refNum);
				payment1.setPaymentamt(amt);
				payment1.setCardnumber(cardNum);
				modifiedList.add(payment1);
			
		}
		
		return modifiedList;
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
	// Used for generating unique random numbers for reference number  
    public static long generateRandomUnique6DigitNumber() {
        Random random = new Random();
        long lowerBound = 100_000;
        long upperBound = 999_999;
        
        long uniqueNumber = lowerBound + random.nextLong() % (upperBound - lowerBound + 1);
        
        return Math.abs(uniqueNumber);
    }

    // Used for generating unique random numbers for transaction id 
    public static long generateRandomPositive7DigitNumber() {
        Random random = new Random();
        long lowerBound = 1_000_000;
        long upperBound = 9_999_999;

        long uniqueNumber = lowerBound + random.nextLong() % (upperBound - lowerBound + 1);

        return Math.abs(uniqueNumber);
    }





}
