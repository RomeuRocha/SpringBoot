package com.romeurocha.springboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.romeurocha.springboot.domain.Category;
import com.romeurocha.springboot.repositories.CategoryRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	CategoryRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		repository.saveAll(Arrays.asList(cat1,cat2));
	}

}
