package com.romeurocha.springboot.domain.enuns;

public enum StatusPayment {
	PENDING(1,"Pendente"),
	SETTLED(2,"Quitado"),
	CANCELED(3,"Cancelado");
	
	private int cod;
	private String descricao;
	
	private StatusPayment(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static StatusPayment toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (StatusPayment x : StatusPayment.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("id inválido :"+cod); 
	}
	
}
