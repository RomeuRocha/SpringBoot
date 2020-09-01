package com.romeurocha.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id_payment")
public class CredCard extends Payment{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer installments;
	
	public CredCard() {
		
	}
	
	public CredCard(Integer id, Integer statusPayment, Order order,Integer installments) {
		super(id, statusPayment, order);
		this.installments = installments;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
	
	
}
