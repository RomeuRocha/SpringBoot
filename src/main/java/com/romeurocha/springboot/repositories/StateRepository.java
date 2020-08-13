package com.romeurocha.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romeurocha.springboot.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{
	
}
