package br.com.estudo.jdbc.exception;

import java.lang.RuntimeException;
import java.lang.String;
import java.sql.SQLException;

public class DAOException extends RuntimeException {
	
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
