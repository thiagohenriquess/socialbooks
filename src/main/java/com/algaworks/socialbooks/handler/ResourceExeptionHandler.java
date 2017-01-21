package com.algaworks.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.socialbooks.domain.DetalheErro;
import com.algaworks.socialbooks.services.exceptions.AutorEncontradoException;
import com.algaworks.socialbooks.services.exceptions.AutorNaoEncontradoException;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExeptionHandler {

	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalheErro> handlerLivroNaoEncontradoExpetion(LivroNaoEncontradoException e,
			HttpServletRequest request) {

		DetalheErro detalheErro = new DetalheErro();

		detalheErro.setStatus(404l);
		detalheErro.setTitulo("Livro não encontrado");
		detalheErro.setUrl("thiagohenriq@gmail.com");
		detalheErro.setTimeStamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalheErro);
	}

	@ExceptionHandler(AutorNaoEncontradoException.class)
	public ResponseEntity<DetalheErro> hadlerAutorNaoEncontradoException(AutorNaoEncontradoException e,
			HttpServletRequest request) {

		DetalheErro detalheErro = new DetalheErro();

		detalheErro.setStatus(404l);
		detalheErro.setTitulo("Autor não encontrado");
		detalheErro.setUrl("thiagohenriq@gmail.com");
		detalheErro.setTimeStamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalheErro);

	}

	@ExceptionHandler(AutorEncontradoException.class)
	public ResponseEntity<DetalheErro> hadlerAutorNaoEncontradoException(AutorEncontradoException e,
			HttpServletRequest request) {

		DetalheErro detalheErro = new DetalheErro();

		detalheErro.setStatus(409l);
		detalheErro.setTitulo("Autor já existe");
		detalheErro.setUrl("thiagohenriq@gmail.com");
		detalheErro.setTimeStamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(detalheErro);

	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalheErro> hadlerDataIntegrityViolationException(DataIntegrityViolationException e,
			HttpServletRequest request) {

		DetalheErro detalheErro = new DetalheErro();

		detalheErro.setStatus(400l);
		detalheErro.setTitulo("Recurso não existe");
		detalheErro.setUrl("thiagohenriq@gmail.com");
		detalheErro.setTimeStamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(detalheErro);

	}
}
