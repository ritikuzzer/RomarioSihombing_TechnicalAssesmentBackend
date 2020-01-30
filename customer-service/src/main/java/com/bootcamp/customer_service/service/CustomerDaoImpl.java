package com.bootcamp.kelompok4.customer_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.kelompok4.customer_service.entity.Customer;
import com.bootcamp.kelompok4.customer_service.repo.CustomerRepo;

public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	CustomerRepo repo;
	
	@Override
	public Customer getByCif(String cif) throws Exception {
		Optional<Customer> customers = repo.findById(cif);
		
		try {
			if(customers.isPresent()) {
				return customers.get();
			}
			
			else {
				throw new Exception("Customer with CIF : " + cif + " not found");
			}
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Customer> getCustomerByFirstNameLike(String firstname) throws Exception {

		List<Customer> listCustomers =  repo.findByfirstnameLike("%"+ firstname +"%");
		try {
			if (listCustomers.isEmpty()) {
				throw new Exception("Customer with firstname : " + firstname +" not found");
			}
			else {
				return listCustomers;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Customer> getAll() throws Exception {
		List<Customer> listCustomer = repo.findAll();
		try {
			if(listCustomer.isEmpty()) {
			throw new Exception("List Customer Not Found");	
			}
			
			return listCustomer;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public Customer addCustomer(Customer customer) throws Exception {
		Optional<Customer> oldCustomer = repo.findById(customer.getCif());
		try {
			if(oldCustomer.isPresent()) {
			throw new Exception("Customer with cif : " + customer.getCif() + ", Already Exist");	
			}
			
			else {
				Customer newCustomer = repo.save(customer);
				
				return newCustomer;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Customer updateCustomer(String cif , Customer customer) throws Exception {
		Optional<Customer> oldCustomer = repo.findById(cif);
		
		try {
			if(oldCustomer.isPresent()) {
				Customer newModel = oldCustomer.get();
				newModel.setFirstname(customer.getFirstname());
				newModel.setLastname(customer.getLastname());
				newModel.setAddress(customer.getAddress());
				newModel.setBirth_date(customer.getBirth_date());
				newModel.setBirth_place(customer.getBirth_place());				
				return repo.save(newModel);	
			}
	
			throw new Exception("Customer with Cif : " + customer.getCif() + " not found");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Boolean deleteCustomer(String cif) throws Exception {
		
		Customer exist = getByCif(cif);
		
		try {
			if (exist == null) {
				throw new Exception("Customer Not Found , Can't be delete");
			}
			
			else {
				repo.deleteById(cif);
				return true;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
