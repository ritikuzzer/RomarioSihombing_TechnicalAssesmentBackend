package com.bootcamp.kelompok4.gatewayservice;

import org.springframework.context.annotation.Bean;

import com.bootcamp.commonResponse.kelompok4.CommonResponseGenerator;



public class DaoSpringbootConfig {


	@Bean
	public CommonResponseGenerator commonResponseGenerator() {
		
		return new CommonResponseGenerator();
	}
	}
	

