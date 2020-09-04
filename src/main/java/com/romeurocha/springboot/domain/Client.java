package com.romeurocha.springboot.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.romeurocha.springboot.domain.enuns.TypeClient;

@Entity
public class Client implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String cpfOuCnpj;
	
	private Integer type;
	
	@OneToMany(mappedBy = "client")
	private List<Addres> addres = new ArrayList<Addres>();
	
	@ElementCollection
	@CollectionTable(name ="phones")
	private Set<String> phones = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	public Client() {
		
	}

	public Client(Integer id, String name, String email, String cpfOuCnpj, TypeClient type) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.type = type.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public TypeClient getType() {
		return TypeClient.toEnum(type);
	}

	public void setType(TypeClient type) {
		this.type = type.getCod();
	}

	public List<Addres> getAddres() {
		return addres;
	}

	public Set<String> getPhones() {
		return phones;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
