package com.romeurocha.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romeurocha.springboot.domain.Client;;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
	
}
