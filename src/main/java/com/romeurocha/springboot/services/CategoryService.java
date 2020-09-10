package com.romeurocha.springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romeurocha.springboot.domain.Category;
import com.romeurocha.springboot.repositories.CategoryRepository;
import com.romeurocha.springboot.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public Category findById(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Category.class.getName())); 
	}
	
	public Category insert(Category obj) {
		obj.setId(null);
		return repository.save(obj);
	}

}
