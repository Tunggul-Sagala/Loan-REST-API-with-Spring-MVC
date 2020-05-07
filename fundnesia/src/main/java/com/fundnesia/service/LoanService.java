package com.fundnesia.service;

import java.util.List;

import com.fundnesia.entity.Loan;

public interface LoanService {
	
	public List<Loan> findAll();

	public void save(Loan loan);

	public Loan findById(int loanId);

	public void deleteById(int loanId);

}
