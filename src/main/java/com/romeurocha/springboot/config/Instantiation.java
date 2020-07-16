package com.romeurocha.springboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.romeurocha.springboot.domain.Category;
import com.romeurocha.springboot.domain.Product;
import com.romeurocha.springboot.repositories.CategoryRepository;
import com.romeurocha.springboot.repositories.ProductRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().add(p2);
		
		p1.getCategories().add(cat1);
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().add(cat1);
		
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
			
	}

}
