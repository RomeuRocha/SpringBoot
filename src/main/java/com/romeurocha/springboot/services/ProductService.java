package com.romeurocha.springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romeurocha.springboot.domain.Product;
import com.romeurocha.springboot.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Product findById(Integer id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElse(null);
	}

}
