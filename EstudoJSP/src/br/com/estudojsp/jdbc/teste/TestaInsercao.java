package br.com.estudojsp.jdbc.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.estudojsp.jdbc.dao.ContatoDao;
import br.com.estudojsp.jdbc.modelo.Contato;

public class TestaInsercao {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Ailton Junior");
		contato.setEmail("ajunior.em@gmail.com");
		String dataDeNascimento = "05/06/1996";
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date = simple.parse(dataDeNascimento);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			contato.setDataNascimento(calendar);
		} catch (ParseException e) {
			throw new RuntimeException("Erro ao parsear a data!", e);
		}
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
	}
}
