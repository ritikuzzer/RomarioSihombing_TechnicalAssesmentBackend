package com.bootcamp.kelompok4.loanservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.kelompok4.loanservice.entity.LoanType;
import com.bootcamp.kelompok4.loanservice.repo.LoanTypeRepo;

public class LoanTypeDaoImpl implements LoanTypeDao {
	
	@Autowired
	LoanTypeRepo repo;
	
	@Override
	public LoanType getByLoanTypeCode(String loanTypeCode) throws Exception {
		Optional<LoanType> loanType = repo.findById(loanTypeCode);
		
		try {
			if (loanType.isPresent()) {
				return loanType.get();
			}
		throw new Exception("Loan type with code : " + loanTypeCode + " not found");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}



}
