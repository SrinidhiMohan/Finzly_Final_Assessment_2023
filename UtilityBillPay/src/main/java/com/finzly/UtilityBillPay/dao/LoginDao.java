package com.finzly.UtilityBillPay.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.finzly.UtilityBillPay.entity.login;
import com.finzly.UtilityBillPay.exceptions.GlobalExceptionHandler;
import com.finzly.UtilityBillPay.exceptions.InvalidPasswordException;
import com.finzly.UtilityBillPay.exceptions.InvalidUserIdException;
@Repository
public class LoginDao {
	@Autowired
	SessionFactory factory;

	public String login(long cid, int otp) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(login.class);
		criteria.add(Restrictions.eq("id", cid));
		try {
		if(criteria.list().isEmpty()) {
			GlobalExceptionHandler.getInvalidUserIdException("Invalid Customer id");
		}
		else {
			List<login> lg = new ArrayList();
			lg = criteria.list();
			login ln =lg.get(0);
			if(ln.getOtp()==otp) {
				return "Welcome " +ln.getCid();
			}
			else {
				GlobalExceptionHandler.getInvalidPasswordException("Invalid Password !!");
			}
		}
		}catch(InvalidUserIdException e){
			return "Invalid Customer Id !!!";
			}
		catch(InvalidPasswordException e) {
			return "Invalid Password !!";
		}
		
		
		return "Welcome " + cid +" !!";
		
	}

}
