package br.com.estudojsp.jdbc.teste;

import br.com.estudojsp.jdbc.ConnectionFactory;

public class TestaConexao {
	public static void main(String[] args) {
		new ConnectionFactory().getConnection();
	}
}
