package br.com.estudo.teste;

import java.text.SimpleDateFormat;

import br.com.estudo.jdbc.dao.LinguagemDao;
import br.com.estudo.jdbc.model.Linguagem;

public class TestaBusca {
	public static void main(String[] args) {
		LinguagemDao linguagemDao = new LinguagemDao();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (Linguagem linguagem : linguagemDao.getLista()) {
			System.out.println("\nId: " + linguagem.getId());
			System.out.println("Nome: " + linguagem.getNome());
			System.out.println("Reputação: " + linguagem.getReputacao());
			System.out.println("Data: " + dateFormat.format(linguagem.getData().getTime()));
		}
		
		Linguagem linguagem = linguagemDao.pesquisa(3);
		System.out.println(linguagem.getId());
		System.out.println(linguagem.getNome());
		System.out.println(dateFormat.format(linguagem.getData().getTime()));
	}
}
