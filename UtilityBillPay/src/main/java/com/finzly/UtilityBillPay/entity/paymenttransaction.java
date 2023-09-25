package com.finzly.UtilityBillPay.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class paymenttransaction {
	
	@Id
	private long transactionid;
	private long cid;
	private long bid;
	private String paymentmethod;
	private Date transactiondate;
	private double paymentamt;
	private String transactionstatus;
	private long referencenumber;
	private long cardnumber;
	private int otp;
	public long getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(long transactionid) {
		this.transactionid = transactionid;
	}
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public long getBid() {
		return bid;
	}
	public void setBid(long bid) {
		this.bid = bid;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	public Date getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}
	public double getPaymentamt() {
		return paymentamt;
	}
	public void setPaymentamt(double paymentamt) {
		this.paymentamt = paymentamt;
	}
	public String getTransactionstatus() {
		return transactionstatus;
	}
	public void setTransactionstatus(String transactionstatus) {
		this.transactionstatus = transactionstatus;
	}
	public long getReferencenumber() {
		return referencenumber;
	}
	public void setReferencenumber(long referencenumber) {
		this.referencenumber = referencenumber;
	}
	public long getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(long cardnumber) {
		this.cardnumber = cardnumber;
	}
	
	
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "paymenttransaction [transactionid=" + transactionid + ", cid=" + cid + ", bid=" + bid
				+ ", paymentmethod=" + paymentmethod + ", transactiondate=" + transactiondate + ", paymentamt="
				+ paymentamt + ", transactionstatus=" + transactionstatus + ", referencenumber=" + referencenumber
				+ ", cardnumber=" + cardnumber + "]";
	}

	
	
	
	

}
