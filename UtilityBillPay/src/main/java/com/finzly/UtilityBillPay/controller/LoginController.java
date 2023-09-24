package com.finzly.UtilityBillPay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.UtilityBillPay.service.LoginService;


@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("login")
	public String login(@RequestParam(name = "cid")  long cid, @RequestParam(name = "otp") int otp) {
		return loginService.login(cid,otp);
	}


}
