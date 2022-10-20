package com.desafio.desafioInterestRates.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.desafio.desafioInterestRates.dominio.Taxa;
import com.desafio.desafioInterestRates.repositorio.RepositorioTaxa;

@Configuration
public class Instantiation implements CommandLineRunner {

	// injecao do RepositorioTaxa para fazer operacoes com o  banco de dados
	@Autowired
	private RepositorioTaxa repoTaxa;
	
	@Override
	public void run(String... args) throws Exception {

		Taxa teste1 = new Taxa(null, "23/03/1998",150.5);
		Taxa teste2 = new Taxa(null, "23/04/1998",151.5);
		Taxa teste3 = new Taxa(null, "23/05/1998",153.5);
		
		repoTaxa.saveAll(Arrays.asList(teste1,teste2,teste3));
	}

}
