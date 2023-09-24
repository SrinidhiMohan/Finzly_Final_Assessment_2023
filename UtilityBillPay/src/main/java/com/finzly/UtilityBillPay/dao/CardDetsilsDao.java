package com.finzly.UtilityBillPay.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.UtilityBillPay.entity.carddetails;

@Repository
public class CardDetsilsDao {
	
	@Autowired
	SessionFactory factory;

	public String addCardDetails(carddetails carddetails) {
		Session session = factory.openSession();
		session.save(carddetails);
		session.beginTransaction().commit();
		return "Card Details was added successfully !";
	}

}
