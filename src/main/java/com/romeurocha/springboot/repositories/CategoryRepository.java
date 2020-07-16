package com.romeurocha.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romeurocha.springboot.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
