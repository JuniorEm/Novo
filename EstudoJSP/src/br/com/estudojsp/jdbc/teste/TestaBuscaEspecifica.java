package br.com.estudojsp.jdbc.teste;

import br.com.estudojsp.jdbc.dao.ContatoDao;
import br.com.estudojsp.jdbc.modelo.Contato;

public class TestaBuscaEspecifica {
	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		for (Contato contato : dao.getListaEspecifica("a"))
			System.out.println(contato.getNome());
	}
}
