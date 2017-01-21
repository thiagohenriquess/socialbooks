package com.algaworks.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Comentario;
import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.ComentariosRepository;

@Service
public class ComentariosService {

	@Autowired
	private LivrosService livrosService;

	@Autowired
	private ComentariosRepository comentariosRepository;

	public Comentario salvarComentario(Long livroId, Comentario comentario) {

		Livro livro = livrosService.buscar(livroId);

		comentario.setLivro(livro);
		comentario.setData(new Date());

		return comentariosRepository.save(comentario);

	}

	public List<Comentario> listarComentarios(Long livroId) {
		
		Livro livro = livrosService.buscar(livroId);
		
		return livro.getComentarios();		
	}

}
