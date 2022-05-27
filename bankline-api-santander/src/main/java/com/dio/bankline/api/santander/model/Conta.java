package com.dio.bankline.api.santander.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Conta {
	
	//atributos
	
	@Column(name = "conta_numero")
	private Long numero;
	
	@Column(name = "conta_saldo")
	private Double saldo;
		
	//métodos
		
	public Long getNumero() {
			
		return numero;
			
	}
		
	public void setNumero(Long numero) {
			
		this.numero = numero;
			
	}
		
	public Double getSaldo() {
			
		return saldo;
			
	}
		
	public void setSaldo(Double saldo) {
			
		this.saldo = saldo;
			
	}

}
