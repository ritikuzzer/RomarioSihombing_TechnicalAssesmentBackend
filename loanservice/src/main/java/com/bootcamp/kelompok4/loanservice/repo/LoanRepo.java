package com.bootcamp.kelompok4.loanservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.kelompok4.loanservice.entity.Loan;

public interface LoanRepo extends JpaRepository<Loan, Integer> {

	List<Loan> findByCifLike(String cif);
	List<Loan> findByLoanTypeCodeLike(String loanTypeCode);
}
