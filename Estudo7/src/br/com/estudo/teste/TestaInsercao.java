package br.com.estudo.teste;

import java.util.Calendar;

import br.com.estudo.jdbc.dao.LinguagemDao;
import br.com.estudo.jdbc.model.Linguagem;

public class TestaInsercao {
	public static void main(String[] args) {
		Linguagem linguagem = new Linguagem();
		linguagem.setNome("CSharp");
		linguagem.setReputacao(25);
		Calendar calendar = Calendar.getInstance();
		calendar.set(2002, 04, 06);
		linguagem.setData(calendar);
		
		LinguagemDao dao = new LinguagemDao();
		dao.adiciona(linguagem);
	}
}
