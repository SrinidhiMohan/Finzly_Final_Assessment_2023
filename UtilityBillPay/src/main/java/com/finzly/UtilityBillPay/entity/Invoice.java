package com.finzly.UtilityBillPay.entity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Invoice {
	
	@Id
	private long invoiceid;
	private long billingid;
	private long cid;
	private Date invoicedate;
	private Date billduedate;
	private double totalamt;
	private double earlypaymentdiscount;
	private double onlinepaymentdisount;
	private double totaldiscount;
	private String paymentstatus;
	public long getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(long invoiceid) {
		this.invoiceid = invoiceid;
	}
	public long getBillingid() {
		return billingid;
	}
	public void setBillingid(long billingid) {
		this.billingid = billingid;
	}
	public Date getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(Date invoicedate) {
		this.invoicedate = invoicedate;
	}
	public Date getBillduedate() {
		return billduedate;
	}
	public void setBillduedate(Date billduedate) {
		this.billduedate = billduedate;
	}
	public double getTotalamt() {
		return totalamt;
	}
	public void setTotalamt(double totalamt) {
		this.totalamt = totalamt;
	}
	public double getEarlypaymentdiscount() {
		return earlypaymentdiscount;
	}
	public void setEarlypaymentdiscount(double earlypaymentdiscount) {
		this.earlypaymentdiscount = earlypaymentdiscount;
	}
	public double getOnlinepaymentdisount() {
		return onlinepaymentdisount;
	}
	public void setOnlinepaymentdisount(double onlinepaymentdisount) {
		this.onlinepaymentdisount = onlinepaymentdisount;
	}
	public double getTotaldiscount() {
		return totaldiscount;
	}
	public void setTotaldiscount(double totaldiscount) {
		this.totaldiscount = totaldiscount;
	}
	public String getPaymentstatus() {
		return paymentstatus;
	}
	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
	
	@Override
	public String toString() {
		return "Invoice [invoiceid=" + invoiceid + ", billingid=" + billingid + ", invoicedate=" + invoicedate
				+ ", billduedate=" + billduedate + ", totalamt=" + totalamt + ", earlypaymentdiscount="
				+ earlypaymentdiscount + ", onlinepaymentdisount=" + onlinepaymentdisount + ", totaldiscount="
				+ totaldiscount + ", paymentstatus=" + paymentstatus + "]";
	}
	
	
	

}
