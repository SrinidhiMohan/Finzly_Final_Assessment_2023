package com.finzly.UtilityBillPay.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class customerdetails {
	
	@Id
    private long cid;	
	private String customername;
	private int houseno;
	private String address;	
	private long pincode;	
	private String state;	
	private String country;	
	private String emailid;	
	private String mobileno;
	
	@OneToOne(cascade = CascadeType.ALL)
	login login;
	

	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public int getHouseno() {
		return houseno;
	}
	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	
	public login getLogin() {
		return login;
	}
	public void setLogin(login login) {
		this.login = login;
	}
	@Override
	public String toString() {
		return "customerdetails [cid=" + cid + ", customername=" + customername + ", houseno=" + houseno + ", address="
				+ address + ", pincode=" + pincode + ", state=" + state + ", country=" + country + ", emailid="
				+ emailid + ", mobileno=" + mobileno + "]";
	}
	
	
	
}
