package com.romeurocha.springboot.domain.enuns;

public enum TypeClient {
	
	PERSONPHYSICAL(1,"Pessoa Física"),
	PERSONLEGAL(2,"Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private TypeClient(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return this.cod;
	}
	public String getDescricao() {
		return this.descricao;
	}
	
	public static TypeClient toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (TypeClient x : TypeClient.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("id inválido :"+cod); 
	}
	
}
