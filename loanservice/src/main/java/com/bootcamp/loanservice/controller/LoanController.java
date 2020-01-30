package com.bootcamp.kelompok4.loanservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.bootcamp.commonResponse.kelompok4.dto.DetailLoan;
import com.bootcamp.commonResponse.kelompok4.dto.LoanDto;
import com.bootcamp.kelompok4.loanservice.entity.Loan;
import com.bootcamp.kelompok4.loanservice.entity.LoanType;
import com.bootcamp.kelompok4.loanservice.service.LoanDao;
import com.bootcamp.kelompok4.loanservice.service.LoanTypeDao;

@RestController
@CrossOrigin(origins = "*")
public class LoanController {

	@Autowired
	LoanDao loanDao;
	
	@Autowired
	LoanTypeDao loanTypeDao;
		
	@Autowired
	CommonResponseGenerator comgen;
	
	private static final String LOAN_PATH_LOAN_NUMBER = "loannumber";
	private static final String LOAN_PATH_LOAN_TYPE = "loantype";
	private static final String LOAN_LOAN_NUMBER_ADDR =  "/" + LOAN_PATH_LOAN_NUMBER;
	private static final String LOAN_LOAN_TYPE_ADDR = "/" + LOAN_PATH_LOAN_TYPE;
	private static final String LOAN_BY_LOAN_NUMBER_ADDR =  "/{" + LOAN_PATH_LOAN_NUMBER + "}";
	
	@GetMapping
	public CommonResponse<List<LoanDto>> getAllLoan() throws Exception{
		List<Loan> oldModel = loanDao.getAll();
		ModelMapper modelMapper = new ModelMapper();
		List<LoanDto> newModel =
			    oldModel
			        .stream()
			        .map(source -> modelMapper.map(source, LoanDto.class))
			        .collect(Collectors.toList());	
		CommonResponse<List<LoanDto>> listLoan = comgen.generateCommonResponse(newModel);
		return listLoan;
	}
	
	
	@CrossOrigin(origins="*")
	@GetMapping(LOAN_BY_LOAN_NUMBER_ADDR)
	public CommonResponse<DetailLoan> findByCif(@PathVariable(name="loannumber") int loannumber) throws Exception {
		Loan loan = loanDao.getByLoanNumber(loannumber);
		DetailLoan detail = new DetailLoan();
		LoanType loanType = loanTypeDao.getByLoanTypeCode(loan.getLoanTypeCode());
		
		detail.setLoanNumber(loan.getLoanNumber());
		detail.setLoanTypeCode(loan.getLoanTypeCode());
		detail.setAmmount(loan.getAmmount());
		detail.setBalance(loan.getBalance());
		detail.setOpenDate(loan.getOpenDate());
		detail.setDueDate(loan.getDueDate());
		detail.setTenor(loan.getTenor());
		detail.setCif(loan.getCif());
		detail.setLoanTypeDesc(loanType.getLoanTypeDesc());
		
		CommonResponse<DetailLoan> result = comgen.generateCommonResponse(detail);
		return result;
	}
	
	@GetMapping(LOAN_LOAN_NUMBER_ADDR)
	public CommonResponse<List<LoanDto>> findByCifLike(@RequestParam("cif") String cif) throws Exception{
	List<Loan> oldModel =  loanDao.findByCifLike(cif);
	ModelMapper modelMapper= new ModelMapper();
	List<LoanDto> newModel =
		    oldModel
		        .stream()
		        .map(source -> modelMapper.map(source, LoanDto.class))
		        .collect(Collectors.toList());	
	CommonResponse<List<LoanDto>> listLoan = comgen.generateCommonResponse(newModel);
	return listLoan;
	}
	
	@GetMapping(LOAN_LOAN_TYPE_ADDR)
	public CommonResponse<List<LoanDto>> findByLoanTypeCodeLike(@RequestParam("loantype") String loantype) throws Exception{
	List<Loan> oldModel =  loanDao.findByLoanTypeCodeLike(loantype);
	ModelMapper modelMapper= new ModelMapper();
	List<LoanDto> newModel =
		    oldModel
		        .stream()
		        .map(source -> modelMapper.map(source, LoanDto.class))
		        .collect(Collectors.toList());	
	CommonResponse<List<LoanDto>> listLoan = comgen.generateCommonResponse(newModel);
	return listLoan;
	}	

	@PutMapping(LOAN_BY_LOAN_NUMBER_ADDR)
	public CommonResponse<LoanDto> update(@PathVariable(name="loannumber") int loannumber, @RequestBody LoanDto loanDto) throws Exception  {
		ModelMapper modelMapper = new ModelMapper();
		Loan loan = modelMapper.map(loanDto , Loan.class);
		loanDao.update(loannumber, loan);
		CommonResponse<LoanDto> result = comgen.generateCommonResponse(loanDto);
		return result;
	}
	
	@PostMapping
	public CommonResponse<LoanDto> add(@RequestBody LoanDto loanDto) throws Exception{
		ModelMapper modelMapper = new ModelMapper();
		Loan loan = modelMapper.map(loanDto , Loan.class);
		loanDao.add(loan);
		CommonResponse<LoanDto> result = comgen.generateCommonResponse(loanDto);
		return result;
	}
	
	
	
	
	@ExceptionHandler
	public CommonResponse<String> exception(Exception ex) throws Exception {

		CommonResponse<String> resp = 
				comgen.generateCommonResponse("X01", ex.getMessage(), String.class);

		return resp;
	}
	
	
	
}
