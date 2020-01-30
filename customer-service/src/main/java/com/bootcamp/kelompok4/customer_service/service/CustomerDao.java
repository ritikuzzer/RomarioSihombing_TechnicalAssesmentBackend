package com.bootcamp.kelompok4.customer_service.service;

import java.util.List;

import com.bootcamp.kelompok4.customer_service.entity.Customer;

public interface CustomerDao {
	


	List<Customer> getAll() throws Exception;
	Customer getByCif(String cif) throws Exception;
	List<Customer> getCustomerByFirstNameLike(String firstname) throws Exception;
	Customer addCustomer(Customer customer) throws Exception; 
	Customer updateCustomer(String cif , Customer customer) throws Exception;
	Boolean deleteCustomer(String cif) throws Exception;
		
}
