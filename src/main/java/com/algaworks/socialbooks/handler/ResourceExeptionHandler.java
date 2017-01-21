package com.algaworks.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.socialbooks.domain.DetalheErro;
import com.algaworks.socialbooks.services.exceptions.AutorNaoEncontradoException;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExeptionHandler {

	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalheErro> handlerLivroNaoEncontradoExpetion(LivroNaoEncontradoException e, 
															HttpServletRequest request){
		
		DetalheErro detalheErro = new DetalheErro();
		
		detalheErro.setStatus(404l);
		detalheErro.setTitulo("Livro não encontrado");
		detalheErro.setUrl("thiagohenriq@gmail.com");
		detalheErro.setTimeStamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalheErro);		
	}
	
	public ResponseEntity<DetalheErro> hadlerAutorNaoEncontradoException(AutorNaoEncontradoException e, HttpServletRequest request){
		
		DetalheErro detalheErro = new DetalheErro();
		
		detalheErro.setStatus(404l);
		detalheErro.setTitulo("Autor não encontrado");
		detalheErro.setUrl("thiagohenriq@gmail.com");
		detalheErro.setTimeStamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalheErro);
		
	}
	
}
