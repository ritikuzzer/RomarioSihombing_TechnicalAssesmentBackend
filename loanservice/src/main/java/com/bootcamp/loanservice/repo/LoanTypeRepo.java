package com.bootcamp.kelompok4.loanservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.kelompok4.loanservice.entity.LoanType;

public interface LoanTypeRepo extends JpaRepository<LoanType, String> {

}
