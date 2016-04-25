package br.com.juniorsite.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost/juniorsite", "root", "1234");
		} catch (SQLException e) {
			throw new RuntimeException("Impossível realizar conexão com o Banco de Dados", e);
		}
	}
}
