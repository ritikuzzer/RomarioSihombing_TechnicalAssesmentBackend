package com.bootcamp.kelompok4.loanservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoanType {

	@Id
	private String loanTypeCode;
	private String loanTypeDesc;
	
	public String getLoanTypeCode() {
		return loanTypeCode;
	}
	public void setLoanTypeCode(String loanTypeCode) {
		this.loanTypeCode = loanTypeCode;
	}
	public String getLoanTypeDesc() {
		return loanTypeDesc;
	}
	public void setLoanTypeDesc(String loanTypeDesc) {
		this.loanTypeDesc = loanTypeDesc;
	}
	
	
}
