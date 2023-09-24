package com.finzly.UtilityBillPay.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.finzly.UtilityBillPay.entity.TransactionOtp;
import com.finzly.UtilityBillPay.entity.paymenttransaction;

@Repository
public class PaymentTransactionDao {
	 private Random random = new Random();
	 private Set<Integer> generatedNumbers = new HashSet<>();

	@Autowired
	SessionFactory factory;

	public String payOnline(paymenttransaction paymenttransaction) {
		int validOtp=0;
		
		Session session = factory.openSession();
		TransactionOtp totp = new TransactionOtp();
		totp.setTransactionid(paymenttransaction.getTransactionid());
		totp.setOtp(generateRandomUniqueNumber());
        session.save(totp);
        Criteria criteria = session.createCriteria(TransactionOtp.class);
        List<TransactionOtp> transactionotp = new ArrayList();
        for (TransactionOtp transactionOtp2 : transactionotp) {
			if(transactionOtp2.getTransactionid()==paymenttransaction.getTransactionid()) {
				paymenttransaction.setOtp(transactionOtp2.getOtp());	
			}
		}
		session.save(paymenttransaction);
		session.beginTransaction().commit();
		return "Transaction of Rs "+ paymenttransaction.getPaymentamt()+" was successfull !";
	}
	
	
	public String deletePaymentById(long transactionid) {
		Session session = factory.openSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(paymenttransaction.class);
		criteria.add(Restrictions.eq("transactionid",transactionid));
		paymenttransaction payment = (paymenttransaction) criteria.uniqueResult();
		session.delete(payment);
		tr.commit();
		return "Payment with transaction id: " + transactionid+ " Deleted ";
	}
	
	
	
	
	
	
	
	
	
    // Generate a random unique five-digit number
    private int generateRandomUniqueNumber() {
        int min = 10000; // Minimum five-digit number
        int max = 99999; // Maximum five-digit number

        while (true) {
            int randomNumber = random.nextInt(max - min + 1) + min;

            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
                return randomNumber;
            }
        }
    }


}
