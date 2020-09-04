package com.romeurocha.springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romeurocha.springboot.domain.Payment;
import com.romeurocha.springboot.repositories.PaymentRepository;
import com.romeurocha.springboot.services.exceptions.ObjectNotFoundException;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repository;

	public Payment findById(Integer id) {
		Optional<Payment> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Payment.class.getName())); 
	}

}
