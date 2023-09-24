package com.finzly.UtilityBillPay.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TransactionOtp {
	@Id
	private long transactionid;
	private int otp;
	public long getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(long transactionid) {
		this.transactionid = transactionid;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	
	
	@Override
	public String toString() {
		return "TransactionOtp [transactionid=" + transactionid + ", otp=" + otp + "]";
	}
	
	
	
}
