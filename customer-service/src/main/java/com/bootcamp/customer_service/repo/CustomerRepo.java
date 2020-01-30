package com.bootcamp.kelompok4.customer_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.kelompok4.customer_service.entity.Customer;

public interface CustomerRepo  extends JpaRepository<Customer, String>{
	List<Customer> findByfirstnameLike(String string);
}
