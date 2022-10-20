package com.desafio.desafioInterestRates.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.desafioInterestRates.dominio.Taxa;
import com.desafio.desafioInterestRates.dto.TaxaDTO;
import com.desafio.desafioInterestRates.repositorio.RepositorioTaxa;
import com.desafio.desafioInterestRates.servico.exception.ObjetoNaoEncontradoException;

@Service
public class TaxaServico {
	@Autowired // responsavel por instanciar automaticamente o objeto do tipo RepositorioTaxa
	private RepositorioTaxa repo;
	// responsavel por retornar todos os dados do banco:
	public List<Taxa> findAll() {
		return repo.findAll();
	}
	
	// responsavel por retornar dados de acordo com o id inserido:
	
	public Taxa findById(String id) {
		 Optional<Taxa> obj= repo.findById(id);
		 return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));


	
	}
	// metodo de inserir dados com o post:
	public Taxa inserir(Taxa obj) {
		return repo.insert(obj);
	}
	
	public void deletar(String id) {
		findById(id);
		repo.deleteById(id);
		
	} public Taxa atualiza(Taxa obj) {
		Taxa novoObj = findById(obj.getId());
		atualizaData(novoObj, obj);
		return repo.save(novoObj);
	}
	
	private void atualizaData(Taxa novoObj, Taxa obj) {
		
		novoObj.setData(obj.getData());
		novoObj.setvalor(obj.getValor());
	}

	//conversor de objetos dto em objetos Taxa:
	public Taxa fromDTO(TaxaDTO objdto) {
		return new Taxa(objdto.getId(),objdto.getData(),objdto.getValor());
	}
	
	
}
