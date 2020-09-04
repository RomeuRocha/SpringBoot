package com.romeurocha.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romeurocha.springboot.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
}
