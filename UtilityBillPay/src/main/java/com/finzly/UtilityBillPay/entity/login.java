package com.finzly.UtilityBillPay.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class login {
	
	@Id
	  private long cid;	
	  private int otp;
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}

}
