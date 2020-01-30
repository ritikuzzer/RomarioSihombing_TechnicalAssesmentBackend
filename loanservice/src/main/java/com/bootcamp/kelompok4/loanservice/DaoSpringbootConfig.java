package com.bootcamp.kelompok4.loanservice;

import org.springframework.context.annotation.Bean;

import com.bootcamp.commonResponse.kelompok4.CommonResponseGenerator;
import com.bootcamp.kelompok4.loanservice.service.LoanDao;
import com.bootcamp.kelompok4.loanservice.service.LoanDaoImpl;
import com.bootcamp.kelompok4.loanservice.service.LoanTypeDao;
import com.bootcamp.kelompok4.loanservice.service.LoanTypeDaoImpl;

public class DaoSpringbootConfig {


	@Bean
	public CommonResponseGenerator commonResponseGenerator() {
		
		return new CommonResponseGenerator();
	}
	
	@Bean
	public LoanDao loanDao () {
		return new LoanDaoImpl();			
	}
	
	@Bean
	public LoanTypeDao loanTypeDao()  {
		
		return new LoanTypeDaoImpl();
		
	}



	
	
	

	}
	

