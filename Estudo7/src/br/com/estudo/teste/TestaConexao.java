package br.com.estudo.teste;

import java.sql.Connection;

import br.com.estudo.jdbc.ConnectionFactory;

public class TestaConexao {
	public static void main(String[] args) {
		Connection connection = new ConnectionFactory().getConnection();
	}
}
