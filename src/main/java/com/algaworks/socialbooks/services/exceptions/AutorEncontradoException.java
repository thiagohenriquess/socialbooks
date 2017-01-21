package com.algaworks.socialbooks.services.exceptions;

public class AutorEncontradoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8078510019397374854L;

	public AutorEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public AutorEncontradoException(String mensagem, Throwable causa) {
		super(mensagem,causa);
	}
}
