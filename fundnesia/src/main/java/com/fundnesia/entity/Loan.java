package com.fundnesia.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loan")
public class Loan {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="tenure")
	private int tenure;
	
	@Column(name="ticket_size")
	private BigDecimal ticketSize;
	
	@Column(name="fee")
	private BigDecimal fee;
	
	@Column(name="total_loan")
	private BigDecimal totalLoan;
	
	@Column(name="installment_per_month")
	private BigDecimal installmentPerMonth;
	
	@Column(name="status")
	private String status;
	
	public Loan() {
		
	}
	
	public Loan(int tenure, BigDecimal ticketSize, BigDecimal fee, BigDecimal totalLoan, BigDecimal installmentPerMonth,
			String status) {
		this.tenure = tenure;
		this.ticketSize = ticketSize;
		this.fee = fee;
		this.totalLoan = totalLoan;
		this.installmentPerMonth = installmentPerMonth;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getTenure() {
		return tenure;
	}


	public void setTenure(int tenure) {
		this.tenure = tenure;
	}


	public BigDecimal getTicketSize() {
		return ticketSize;
	}

	public void setTicketSize(BigDecimal ticketSize) {
		this.ticketSize = ticketSize;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public BigDecimal getTotalLoan() {
		return totalLoan;
	}

	public void setTotalLoan(BigDecimal totalLoan) {
		this.totalLoan = totalLoan;
	}

	public BigDecimal getInstallmentPerMonth() {
		return installmentPerMonth;
	}

	public void setInstallmentPerMonth(BigDecimal installmentPerMonth) {
		this.installmentPerMonth = installmentPerMonth;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", ticketSize=" + ticketSize + ", fee=" + fee + ", totalLoan=" + totalLoan
				+ ", installmentPerMonth=" + installmentPerMonth + ", status=" + status + "]";
	}
	
	
}
