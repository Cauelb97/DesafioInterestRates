package com.desafio.desafioInterestRates.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.desafioInterestRates.dominio.Taxa;
import com.desafio.desafioInterestRates.dto.TaxaDTO;
import com.desafio.desafioInterestRates.repositorio.RepositorioTaxa;
import com.desafio.desafioInterestRates.servico.TaxaServico;

@RestController
@RequestMapping(value="/taxas")
public class TaxaRecurso {
	
	@Autowired
	private TaxaServico servico;
	
	// Primeiro endpoint:
	@RequestMapping(method = RequestMethod.GET)
	//ResponseEntity para retornar respostas HTTP com possiveis cabecalhos e mensagens de erros
public ResponseEntity< List<TaxaDTO>> findAll(){
	
	List<Taxa> lista = servico.findAll();
	// a linha abaixo converte minha lista original para uma lista DTO.
	List<TaxaDTO> listadto = lista.stream().map(x -> new TaxaDTO(x)).collect(Collectors.toList());
	return ResponseEntity.ok().body(listadto);
}
	
	// Segundo endpoint: 

		@GetMapping("/expectativas/{data}")
		public Taxa listaData(@PathVariable(value="data") String data) {
			return (Taxa) RepositorioTaxa.findByData(data);
		}
	//METODO PARA RETORNAR DE ACORDO COM O ID:
	@RequestMapping(value="/{id}" ,method = RequestMethod.GET)
	//ResponseEntity para retornar respostas HTTP com possiveis cabecalhos e mensagens de erros
	//@PathVariable para casar o string id com o id da taxa dto e do banco de dados.
public ResponseEntity<TaxaDTO> findById( @PathVariable  String id){
	Taxa obj = servico.findById(id);
		
	return ResponseEntity.ok().body(new TaxaDTO(obj));
}
	// METODO PARA INSERIR UM NOVO DADO:
	@RequestMapping(method = RequestMethod.POST)
	
public ResponseEntity<Void> inserir(@RequestBody TaxaDTO objdto){
	Taxa obj = servico.fromDTO(objdto);
	obj = servico.inserir(obj);
	
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();	
	return  ResponseEntity.created(uri).build();
	
}
	// METODO PARA DELETAR POR ID:
	@RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
	
public ResponseEntity<Void> delete( @PathVariable  String id){
	 servico.deletar(id);
		
	return ResponseEntity.noContent().build();
}
	
	//METODO PARA ATUALIZAR OS DADOS:
	
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	
	public ResponseEntity<Void> atualizar(@RequestBody TaxaDTO objdto, @PathVariable String id){
		Taxa obj = servico.fromDTO(objdto);
		obj.setId(id);
		obj = servico.atualiza(obj);	
		return ResponseEntity.noContent().build();
		
	}
	
}
