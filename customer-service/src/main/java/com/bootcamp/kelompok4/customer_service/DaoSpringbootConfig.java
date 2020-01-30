package com.bootcamp.kelompok4.customer_service;

import org.springframework.context.annotation.Bean;

import com.bootcamp.commonResponse.kelompok4.CommonResponseGenerator;
import com.bootcamp.kelompok4.customer_service.service.CustomerDao;
import com.bootcamp.kelompok4.customer_service.service.CustomerDaoImpl;

public class DaoSpringbootConfig {


	@Bean
	public CommonResponseGenerator commonResponseGenerator() {
		
		return new CommonResponseGenerator();
	}

	@Bean
	public CustomerDao customerDao () {
		return new CustomerDaoImpl();			
	}

	
	
	

	}
	

