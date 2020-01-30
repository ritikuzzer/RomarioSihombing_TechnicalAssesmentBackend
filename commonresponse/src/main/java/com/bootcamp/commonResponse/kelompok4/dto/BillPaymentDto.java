package com.bootcamp.commonResponse.kelompok4.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BillPaymentDto {
	
	private int billingId;
	private double ammount;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date paymentDate;
	
	public int getBillingId() {
		return billingId;
	}
	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}
	public double getAmmount() {
		return ammount;
	}
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
	
}
