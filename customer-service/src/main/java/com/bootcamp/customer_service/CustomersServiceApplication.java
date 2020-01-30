package com.bootcamp.kelompok4.customer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@Import({DaoSpringbootConfig.class})
@EntityScan(("com.bootcamp.kelompok4.customer_service.entity"))
@EnableJpaRepositories(("com.bootcamp.kelompok4.customer_service.repo"))
@ComponentScan(("com.bootcamp"))
@EnableDiscoveryClient
@SpringBootApplication
public class CustomersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersServiceApplication.class, args);
	}

}
