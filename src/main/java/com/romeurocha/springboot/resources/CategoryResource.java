package com.romeurocha.springboot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.romeurocha.springboot.domain.Category;
import com.romeurocha.springboot.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Category> find(@PathVariable Integer id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
}
