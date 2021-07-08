package br.com.dasa.testeDasa.exception;

public class DatabaseErrorException extends Exception {

	public DatabaseErrorException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
