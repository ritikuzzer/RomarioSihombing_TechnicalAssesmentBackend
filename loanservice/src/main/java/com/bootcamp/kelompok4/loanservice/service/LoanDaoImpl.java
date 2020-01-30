package com.bootcamp.kelompok4.loanservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.kelompok4.loanservice.entity.Loan;
import com.bootcamp.kelompok4.loanservice.repo.LoanRepo;

public class LoanDaoImpl implements LoanDao{
	@Autowired
	LoanRepo repo;
	
	@Autowired
	LoanTypeDao loanTypeDao;
	
	@Override
	public List<Loan> getAll() throws Exception {
		List<Loan> listLoan = repo.findAll();	
		
		try {
			if(listLoan.isEmpty()) {
				throw new Exception("List loan not found");
			}
			
			else {
				return listLoan;				
			}
			
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
	

	@Override
	public Loan getByLoanNumber(int loanNumber) throws Exception {
		Optional<Loan> loan = repo.findById(loanNumber);
		
		
		 
		try {
			if (loan.isPresent()) {
		
				return loan.get();
			}
			
			throw new Exception("Loan with loan number : " +  loanNumber + " not found");
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}


	@Override
	public List<Loan> findByCifLike(String cif) throws Exception {
		List<Loan> listLoan =  repo.findByCifLike("%"+ cif +"%");
		try {
			if (listLoan.isEmpty()) {
				throw new Exception("Loan with cif : " + cif +" not found");
			}
			else {
				return listLoan;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());	
	}

}


	@Override
	public List<Loan> findByLoanTypeCodeLike(String loanTypeCode) throws Exception {
		List<Loan> listLoan =  repo.findByLoanTypeCodeLike("%"+ loanTypeCode +"%");
		try {
			if (listLoan.isEmpty()) {
				throw new Exception("Loan with loan type code : " + loanTypeCode +" not found");
			}
			else {
				return listLoan;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());	
	}
	}


	@Override
	public Loan update(int loanNumber, Loan loan) throws Exception {
		Optional<Loan> oldLoan = repo.findById(loanNumber);
		
		try {
			if(oldLoan.isPresent()) {
			Loan newLoan = oldLoan.get();
			newLoan.setLoanTypeCode(loan.getLoanTypeCode());
			newLoan.setAmmount(loan.getAmmount());
			newLoan.setBalance(loan.getBalance());
			newLoan.setOpenDate(loan.getOpenDate());
			newLoan.setDueDate(loan.getDueDate());
			newLoan.setTenor(loan.getTenor());
			
			return repo.save(newLoan);
			}
			
			else {
				throw new Exception("Loan with loan number : " + loanNumber + " not found!");
			}
			
		} catch (Exception e) {
				throw new Exception(e.getMessage());
		}
	}


	@Override
	public Loan add(Loan loan) throws Exception {
		Loan add = getByLoanNumber(loan.getLoanNumber());
		try {
			if(add.equals(null)) {
				
				return repo.save(loan);
			}
			else
			{
				throw new Exception("Loan already exist!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	}



