package br.com.estudo.jdbc.teste;

import br.com.estudo.jdbc.dao.ContatoDao;
import br.com.estudo.jdbc.model.Contato;

public class TestaResultado {
	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		
		for (Contato contatoLista : dao.getLista()) {
			System.out.println(contatoLista.getNome());
		}
	}
}
