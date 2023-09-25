package com.finzly.UtilityBillPay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.UtilityBillPay.dao.LoginDao;

@Service
public class LoginService {
	
	@Autowired
	private LoginDao loginDao;

	public String login(long cid, int otp) {
		return loginDao.login(cid, otp);
		
	}

}
