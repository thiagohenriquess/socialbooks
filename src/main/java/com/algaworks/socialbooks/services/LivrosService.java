package com.algaworks.socialbooks.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.LivrosRepository;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {

	private String mgsNaoEncontrado = "Livro nao encotrado";
	
	@Autowired
	private LivrosRepository livrosRepository;

	public List<Livro> listar() {
		return livrosRepository.findAll();
	}

	public Livro buscar(Long id) {

		Livro livro = livrosRepository.findOne(id);

		if (livro == null) {			
			throw new LivroNaoEncontradoException(mgsNaoEncontrado);
		}

		return livro;
	}

	public Livro salvar(Livro livro) {
		livro.setId(null);

		return livrosRepository.save(livro);
	}

	public void deletar(Long id) {
		try {
			livrosRepository.delete(id);

		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException(mgsNaoEncontrado);
		}
	}
	
	public void atualizar(Livro livro){
		verificarExistencia(livro);
		livrosRepository.save(livro);
	}
	
	public void verificarExistencia(Livro livro){
		buscar(livro.getId());
	}
}
