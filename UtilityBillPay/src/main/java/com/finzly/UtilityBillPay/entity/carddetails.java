package com.finzly.UtilityBillPay.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class carddetails {
	@Id
	private long cardnumber;
	private String cardtype;
	private double balance;
	private double minimumbalance;
	private double transactioncount;
	public long getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(long cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getMinimumbalance() {
		return minimumbalance;
	}
	public void setMinimumbalance(double minimumbalance) {
		this.minimumbalance = minimumbalance;
	}
	public double getTransactioncount() {
		return transactioncount;
	}
	public void setTransactioncount(double transactioncount) {
		this.transactioncount = transactioncount;
	}
	
	
	@Override
	public String toString() {
		return "CardDetails [cardnumber=" + cardnumber + ", cardtype=" + cardtype + ", balance=" + balance
				+ ", minimumbalance=" + minimumbalance + ", transactioncount=" + transactioncount + "]";
	}
	
	
	
	
}
