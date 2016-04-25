package br.com.estudo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost/estudo6", "root", "1234");
		} catch (SQLException e) {
			throw new RuntimeException("A conexão com o Banco de Dados falhou", e);
		}
	}
}
