package com.fundnesia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundnesia.dao.LoanDao;
import com.fundnesia.entity.Loan;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanDao loanDao;
	
	@Override
	@Transactional
	public List<Loan> findAll() {
		return loanDao.findAll();
	}

	@Override
	@Transactional
	public void save(Loan loan) {
		loanDao.save(loan);
	}

	@Override
	@Transactional
	public Loan findById(int loanId) {
		return loanDao.findById(loanId);
	}

	@Override
	@Transactional
	public void deleteById(int loanId) {
		loanDao.deleteById(loanId);
	}

}
