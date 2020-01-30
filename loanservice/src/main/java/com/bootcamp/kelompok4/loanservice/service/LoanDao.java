package com.bootcamp.kelompok4.loanservice.service;

import java.util.List;

import com.bootcamp.kelompok4.loanservice.entity.Loan;

public interface LoanDao {
	
	List<Loan> getAll() throws Exception;
	
	Loan getByLoanNumber(int loanNumber) throws Exception;
	
	List<Loan> findByCifLike(String cif) throws Exception;
	
	List<Loan> findByLoanTypeCodeLike(String loanTypeCode) throws Exception;
	
	Loan update(int loanNumber , Loan loan) throws Exception;
	
	Loan add(Loan loan) throws Exception;

}
