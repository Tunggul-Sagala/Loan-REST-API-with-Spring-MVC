package com.fundnesia.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundnesia.entity.Loan;
import com.fundnesia.exception.LoanNotFoundException;
import com.fundnesia.service.LoanService;

@RestController
@RequestMapping("/api")
public class LoanResource {

	@Autowired
	private LoanService loanService;
	
	@GetMapping("/loans")
	public List<Loan> findAll() {
		List<Loan> loans= loanService.findAll();
		return loans;
	}
	
	@GetMapping("/loans/{loanId}")
	public Loan findById(@PathVariable("loanId") int loanId) {
		Loan loan =loanService.findById(loanId);
		if (loan == null || loanId <0) {
			throw new LoanNotFoundException("Loan not found with id: " + loanId);
		}
		else {
			return loan;
		}
	}
	
	@PostMapping("/loans")
	public Loan save(@RequestBody Loan loan) {
		BigDecimal ticketSize =loan.getTicketSize();
		int tenure =loan.getTenure();
		BigDecimal fee =ticketSize.multiply(BigDecimal.valueOf(tenure * 0.02));
		BigDecimal totalLoan =ticketSize.add(fee);
		BigDecimal installmentPerMonth =totalLoan.divide(BigDecimal.valueOf(tenure));
		loan.setFee(fee);
		loan.setTotalLoan(totalLoan);
		loan.setInstallmentPerMonth(installmentPerMonth);
		loan.setStatus("SUBMITTED");
		
		loanService.save(loan);
		return loan;
	}
	
	@DeleteMapping("/loans/{loanId}")
	public String deleteById(@PathVariable("loanId") int loanId) {
		loanService.deleteById(loanId);
		return "Deleted loan with Id: " + loanId;
	}
	
}
