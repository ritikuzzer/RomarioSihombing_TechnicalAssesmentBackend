package com.bootcamp.kelompok4.loanservice.service;

import com.bootcamp.kelompok4.loanservice.entity.LoanType;

public interface LoanTypeDao {

	LoanType getByLoanTypeCode(String loanTypeCode) throws Exception;
	
}
