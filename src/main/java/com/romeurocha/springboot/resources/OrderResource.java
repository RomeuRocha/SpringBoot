package com.romeurocha.springboot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.romeurocha.springboot.domain.Order;
import com.romeurocha.springboot.services.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Order> find(@PathVariable Integer id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
}
