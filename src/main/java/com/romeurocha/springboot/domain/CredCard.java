package com.romeurocha.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import com.romeurocha.springboot.domain.enuns.StatusPayment;

@Entity
@PrimaryKeyJoinColumn(name="id_payment")
public class CredCard extends Payment{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer installments; //numero de parcelas
	
	public CredCard() {
		
	}
	
	public CredCard(Integer id, StatusPayment statusPayment, Order order,Integer installments) {
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
