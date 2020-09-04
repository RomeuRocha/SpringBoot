package com.romeurocha.springboot.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.romeurocha.springboot.domain.enuns.StatusPayment;

@Entity
@PrimaryKeyJoinColumn(name="id_payment")
public class Bolet extends Payment{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dueDate;//data de vencimento
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date payday;//data de pagamento

	public Bolet() {
		
	}
	
	public Bolet(Integer id, StatusPayment statusPayment, Order order,Date dueDate, Date payday) {
		super(id, statusPayment, order);
		this.dueDate = dueDate;
		this.payday = payday;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPayday() {
		return payday;
	}

	public void setPayday(Date payday) {
		this.payday = payday;
	}
	
	
	
	
}
