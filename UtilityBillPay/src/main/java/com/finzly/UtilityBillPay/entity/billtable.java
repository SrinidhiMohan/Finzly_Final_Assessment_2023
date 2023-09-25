package com.finzly.UtilityBillPay.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class billtable {
 
	@Id
	private long bid;
	private long cid;		
	private Date startdate;
	private Date enddate;
	private Date duedate;
	private int consumedunits;
	
	
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public int getConsumedunits() {
		return consumedunits;
	}
	public void setConsumedunits(int consumedunits) {
		this.consumedunits = consumedunits;
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
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	@Override
	public String toString() {
		return "billtable [bid=" + bid + ", cid=" + cid + ", startdate=" + startdate + ", enddate=" + enddate
				+ ", duedate=" + duedate + ", consumedunits=" + consumedunits + "]";
	}

	
	
	
}
