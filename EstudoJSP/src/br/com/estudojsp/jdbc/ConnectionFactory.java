package br.com.estudojsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost/estudojsp", "root", "1234");
		} catch (SQLException e) {
			throw new RuntimeException("O Driver não pode ser registrado. Houve falha na conexão!", e);
		}
	}
}
