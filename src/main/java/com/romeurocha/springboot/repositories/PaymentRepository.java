package com.romeurocha.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romeurocha.springboot.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
}
