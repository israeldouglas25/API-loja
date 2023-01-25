package br.com.loja.exception;

public class LojaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public LojaException(String message) {
		super(message);
	}

}
