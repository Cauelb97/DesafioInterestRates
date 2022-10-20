package com.desafio.desafioInterestRates.dto;

import java.io.Serializable;

import com.desafio.desafioInterestRates.dominio.Taxa;

public class TaxaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	private String id;
	private String data;
	private double valor;

	//construtor dto1:
	public TaxaDTO() {
		
	}
	// contrutor dto2: para ter uma forma automatizada de instanciar um objt do tipo dto a partir do Taxa
	public TaxaDTO(Taxa obj) {
		id = obj.getId();
		data = obj.getData();
		valor = obj.getValor();
	}
	
	// metodos getters e setters dto:
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	

	
}
