package com.algaworks.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Autor;
import com.algaworks.socialbooks.repository.AutoresRepository;
import com.algaworks.socialbooks.services.exceptions.AutorEncontradoException;
import com.algaworks.socialbooks.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {

	String mensagem = "Autor não encontrado";
	
	@Autowired
	private AutoresRepository autoresRepository;

	public List<Autor> listar() {
		return autoresRepository.findAll();
	}

	public Autor salvar(Autor autor) {
		
		mensagem = "Autor já existente";
		
		if(autor.getId() != null){
			if(autoresRepository.findOne(autor.getId()) != null){
				throw new AutorEncontradoException(mensagem);
			}
		}	
		
		return autoresRepository.save(autor);
	}

	public Autor buscar(Long id) {
		Autor autor = autoresRepository.findOne(id);
		
		if (autor == null){
		 
			throw new AutorNaoEncontradoException(mensagem);
		}

		return autor;
	}
	
	public void deletar(Long id){
		try {
			autoresRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new AutorNaoEncontradoException(mensagem);
		}			
	}
	
	public void atualizar(Autor autor){
		verificarExistencia(autor);
		autoresRepository.save(autor);
	}
	
	public void verificarExistencia(Autor autor){
		buscar(autor.getId());
	}

}
