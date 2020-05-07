package com.fundnesia.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fundnesia.entity.Loan;

@Repository
public class LoanDaoImpl implements LoanDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Loan> findAll() {
		Session session =sessionFactory.getCurrentSession();
		Query<Loan> query =session.createQuery("from Loan", Loan.class);
		return query.getResultList();
	}

	@Override
	public void save(Loan loan) {
		Session session =sessionFactory.getCurrentSession();
		session.saveOrUpdate(loan);
	}

	@Override
	public Loan findById(int loanId) {
		Session session =sessionFactory.getCurrentSession();	
		return session.get(Loan.class, loanId);
	}

	@Override
	public void deleteById(int loanId) {
		Session session =sessionFactory.getCurrentSession();
		Query query =session.createQuery("delete from Loan where id=:loanId");
		query.setParameter("loanId", loanId);
		query.executeUpdate();
	}

}
