package com.romeurocha.springboot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.romeurocha.springboot.domain.Addres;
import com.romeurocha.springboot.services.AddresService;

@RestController
@RequestMapping(value = "/addres")
public class AddresResource {
	
	@Autowired
	private AddresService service;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Addres> find(@PathVariable Integer id) {
		Addres obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
}
