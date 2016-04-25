package br.com.estudojsp.jdbc.teste;

import java.text.SimpleDateFormat;

import br.com.estudojsp.jdbc.dao.ContatoDao;
import br.com.estudojsp.jdbc.modelo.Contato;

public class TestaBusca {

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();

		for (Contato contato : dao.getLista()) {
			System.out.println("\n" + contato.getId());
			System.out.println(contato.getNome());
			System.out.println(contato.getEmail());
			System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime()));
		}
	}

}
