package com.desafio.desafioInterestRates.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafio.desafioInterestRates.dominio.Taxa;


@Repository

public interface RepositorioTaxa extends MongoRepository<Taxa,String>{
	 @Query("select ... query complexa ORDER by ...") 
	static Taxa findByData(String data) {
		// TODO Auto-generated method stub
		return null;
	}

}

