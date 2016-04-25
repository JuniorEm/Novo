package br.com.juniorsite.jdbc.teste;

import br.com.juniorsite.jdbc.dao.ContatoDao;
import br.com.juniorsite.jdbc.model.Contato;

public class TestaBusca {
	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		
		for (Contato contato : dao.getLista())
			System.out.println(contato.getTelefone());
	}
}
