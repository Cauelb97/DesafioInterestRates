package com.desafio.desafioInterestRates.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "taxas")
public class Taxa implements Serializable {

	private static final long serialVersionUID = 1L;

// atributos:
	@Id
	private String id;
	
	private String data;
	
	private double valor;

// construtor 1:
	public Taxa() {
	}

// construtor 2:
	public Taxa(String id, String data, double valor) {
		this.id = id;
		this.data = data;
		this.valor = valor;
	}

// metodo get id:
	public String getId() {
		return id;
	}

// metodo set id:
	public void setId(String id) {
		this.id = id;
	}

// metodo getData:
	public String getData() {
		return data;
	}

// metodo setData:
	public void setData(String data) {
		this.data = data;
	}

// metodo getValor:
	public double getValor() {
		return valor;
	}

//metodo setValor:
	public void setvalor(double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Taxa other = (Taxa) obj;
		return id == other.id;
	}

}
