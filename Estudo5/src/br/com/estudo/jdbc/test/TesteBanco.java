package br.com.estudo.jdbc.test;

import br.com.estudo.jdbc.dao.FrutaDao;
import br.com.estudo.jdbc.model.Fruta;

public class TesteBanco {
	public static void main(String[] args) {
		/*
		Fruta fruta = new Fruta();
		fruta.setNome("Caqui");
		fruta.setPreco(4.5);
		
		Fruta fruta2 = new Fruta();
		fruta2.setNome("Morango");
		fruta2.setPreco(9.88);
		*/
		FrutaDao frutaDao = new FrutaDao();

		/*frutaDao.adiciona(fruta);
		frutaDao.adiciona(fruta2); */
		
		for (Fruta results : frutaDao.getLista()) {
			System.out.println(results.getNome() + " " + results.getPreco());
		}
	}
}
