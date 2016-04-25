package br.com.juniorsite.jdbc.teste;

import java.sql.Connection;

import br.com.juniorsite.jdbc.ConnectionFactory;

public class TestaConexao {
	public static void main(String[] args) {
		Connection connection = new ConnectionFactory().getConnection();
	}
}
