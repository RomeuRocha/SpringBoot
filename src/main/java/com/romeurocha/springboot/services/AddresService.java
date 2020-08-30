package com.romeurocha.springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romeurocha.springboot.domain.Addres;
import com.romeurocha.springboot.repositories.AddresRepository;
import com.romeurocha.springboot.services.exceptions.ObjectNotFoundException;

@Service
public class AddresService {

	@Autowired
	private AddresRepository repository;

	public Addres findById(Integer id) {
		Optional<Addres> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Addres.class.getName())); 
	}

}
