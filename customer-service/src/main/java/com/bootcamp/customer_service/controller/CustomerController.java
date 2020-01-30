package com.bootcamp.kelompok4.customer_service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.commonResponse.kelompok4.CommonResponse;
import com.bootcamp.commonResponse.kelompok4.CommonResponseGenerator;
import com.bootcamp.commonResponse.kelompok4.dto.CustomerDto;
import com.bootcamp.kelompok4.customer_service.entity.Customer;
import com.bootcamp.kelompok4.customer_service.service.CustomerDao;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

	private static final String CUSTOMER_PATH_VARIABLE = "cif";
	private static final String CUSTOMER_PATH_FIRSTNAME = "firstname";
	private static final String CUSTOMER_FIRSTNAME_ADDR =  "/" + CUSTOMER_PATH_FIRSTNAME;
	private static final String CUSTOMER_BY_CIF_ADDR =  "/{"+CUSTOMER_PATH_VARIABLE + "}";
	private static final String CUSTOMER_PAGE_ADDR = "/page";
	
	@Autowired
	CustomerDao customerDao;
		
	@Autowired
	CommonResponseGenerator comgen;
	
	@GetMapping
	public CommonResponse<List<CustomerDto>> getAllCustomer() throws Exception{
		List<Customer> oldModel = customerDao.getAll();
		
		ModelMapper modelMapper= new ModelMapper();
		List<CustomerDto> newModel =
			    oldModel
			        .stream()
			        .map(source -> modelMapper.map(source, CustomerDto.class))
			        .collect(Collectors.toList());	
		CommonResponse<List<CustomerDto>> listCustomer = comgen.generateCommonResponse(newModel);
		return listCustomer;
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(CUSTOMER_BY_CIF_ADDR)
	public CommonResponse<CustomerDto> findByCif(@PathVariable(name="cif") String cif) throws Exception {
		Customer oldModel = customerDao.getByCif(cif);
		ModelMapper modelMapper = new ModelMapper();
		CustomerDto newModel = modelMapper.map(oldModel , CustomerDto.class);
		CommonResponse<CustomerDto> customer = comgen.generateCommonResponse(newModel);
		return customer;
	}
	
	@GetMapping(CUSTOMER_FIRSTNAME_ADDR)
	public CommonResponse<List<CustomerDto>> getCustomerByFirstNameLike(@RequestParam("firstname") String firstname) throws Exception{
	List<Customer> oldModel =  customerDao.getCustomerByFirstNameLike(firstname);
	ModelMapper modelMapper= new ModelMapper();
	List<CustomerDto> newModel =
		    oldModel
		        .stream()
		        .map(source -> modelMapper.map(source, CustomerDto.class))
		        .collect(Collectors.toList());	
	CommonResponse<List<CustomerDto>> listCustomer = comgen.generateCommonResponse(newModel);
	return listCustomer;
	}
	
	@PostMapping
	public CommonResponse<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto) throws Exception {
		ModelMapper modelMapper = new ModelMapper();
		Customer newModel = modelMapper.map(customerDto , Customer.class);
		customerDao.addCustomer(newModel);
		CommonResponse<CustomerDto> result = comgen.generateCommonResponse(customerDto);
		return result;
		
	}
	
	@CrossOrigin(origins="*")
	@PutMapping(CUSTOMER_BY_CIF_ADDR)
	public CommonResponse<CustomerDto> updateCustomer(@PathVariable(name="cif") String cif, @RequestBody CustomerDto customerDto) throws Exception  {
		ModelMapper modelMapper = new ModelMapper();
		Customer customer = modelMapper.map(customerDto ,  Customer.class);
		customerDao.updateCustomer(cif,customer);
		CommonResponse<CustomerDto> result = comgen.generateCommonResponse(customerDto);
		return result;
	}
	
	@DeleteMapping
	public CommonResponse<String> deleteCustomer(@PathVariable(name="cif") String cif) throws Exception{
		customerDao.deleteCustomer(cif);
		
		String result = "Success";
		
		CommonResponse<String> delete = comgen.generateCommonResponse(result);
		
		return delete;
		
	}
	
	
	@ExceptionHandler
	public CommonResponse<String> exception(Exception ex) throws Exception {

		CommonResponse<String> resp = 
				comgen.generateCommonResponse("X01", ex.getMessage(), String.class);

		return resp;
	}
	
	
	
}
