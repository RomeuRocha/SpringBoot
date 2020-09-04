package com.romeurocha.springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romeurocha.springboot.domain.OrderItem;
import com.romeurocha.springboot.repositories.OrderItemRepository;
import com.romeurocha.springboot.services.exceptions.ObjectNotFoundException;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository repository;

	public OrderItem findById(Integer id) {
		Optional<OrderItem> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + OrderItem.class.getName())); 
	}

}
